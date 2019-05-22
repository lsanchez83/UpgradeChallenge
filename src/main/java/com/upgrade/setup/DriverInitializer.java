package com.upgrade.setup;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.upgrade.pages.Declined;
import com.upgrade.pages.Index;
import com.upgrade.pages.Login;
import com.upgrade.pages.PersonalInfo;
import com.upgrade.util.Result;
import com.upgrade.util.State;
import com.upgrade.util.Utility;

public class DriverInitializer {

	String FirtUrl = "https://www.credify.tech/phone/nonDMFunnel";
	String SecondUrl = "https://www.credify.tech/portal/login";
	String ApiUrl = "https://credapi.credify.tech/api/loanapp/v1/states";

	@Parameters("browser")
	@BeforeSuite
	public void TestInitialize(String browser) throws InterruptedException {

		if (browser.equalsIgnoreCase("chrome")) {
			
			System.out.println(" Executing on CHROME");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito", "--disable-notifications", "--start-maximized");
			WebDriverManager.chromedriver().setup();
			PropertyCollections.driver = new ChromeDriver(options);
			PropertyCollections.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			//1
			PropertyCollections.driver.navigate().to(FirtUrl);

		} else {
			
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}
	
	@BeforeTest
	public void test() throws InterruptedException {		
		Thread.sleep(2000);
	}
		
		@Test(priority = 1)
		public void seleniumWebDriver() throws InterruptedException{
		//2
		Index index = new Index();
		index.LoanRate("2000");
		Thread.sleep(2000);
		//3		
		PersonalInfo info = new PersonalInfo();
	    
		Fairy fairy = Fairy.create();
		Person person = fairy.person();		
	        
	    Utility rand = new Utility();
	    
	    String server = "upgrade-challenge.com";	
	    String dob= rand.dob();
	    String anualIncom= rand.RandomNumbers(120000, 190000);
	    String extraIcom = rand.RandomNumbers(5000, 200000);
	    String randMail= rand.RandomNumbers(1, 100);
	    String email=person.getFirstName()+person.getLastName()+randMail+"@"+server;
	    
	    
	    info.PersonalInformation(person,dob, email,anualIncom ,extraIcom , server);		
	    Thread.sleep(5000);
	    index.SignBtn.click();
		
		
		//4
		Declined declined = new Declined();
		declined.SignOut();
		//5
		PropertyCollections.driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		PropertyCollections.driver.navigate().to(SecondUrl);
		Login login = new Login();		
		login.LoginUpgrade(email, person.getPassword());
		
		//6
		Assert.assertTrue(PropertyCollections.driver.getTitle().contains("offer page"));
		Assert.assertEquals(anualIncom, "");
		Assert.assertEquals(extraIcom, "");
		}
		
		@AfterSuite
		public void DirverClose() {
		
		PropertyCollections.driver.close();
		PropertyCollections.driver.quit();
		}
	

	@AfterTest
	public void webApi() throws InterruptedException {

		// ProxySpecification ps =
		// ProxySpecification.host("").withPort(8080).withAuth("", "");
		// given().relaxedHTTPSValidation().proxy(ps).
		// get(loginUrl).then().assertThat();

		Response response = get(ApiUrl);
		if (response.getStatusCode() == 200) {

			Result result = response.as(Result.class);

			if (result != null && result.getStates() != null && !result.getStates().isEmpty()) {
				List<State> states = result.getStates();

				boolean condition1 = (states.stream().anyMatch(st -> st.getLabel() != null && !st.getLabel().isEmpty())
						&& states.size() == 48);
				Assert.assertTrue(condition1, "Not all the state names returned are valid or total state count isn't 48");
				
				if(condition1) {
					
					System.out.println("All the state names returned are valid, and total state count is 48");
				}

				Predicate<? super State> condition2 = st -> st.getMinAge() == 19;
				Assert.assertTrue(states.stream().filter(condition2).count() == 1,"Not only state with min age of 19");

				
				  if(states.stream().filter(condition2).count() == 1) {
					  
				  System.out.println(String.format("State name: %s", states.stream().filter(condition2).findAny().get().getLabel())); 
				  }
				 

				List<State> statesWithAmount3005 = states.stream().filter(st -> st.getMinLoanAmount() == 3005).collect(Collectors.toList());
				boolean condition3 = statesWithAmount3005.size() == 1 && statesWithAmount3005.get(0).getLabel().equals("Georgia");
				
				
				Assert.assertTrue(condition3,"Not only state with min loan amout");
				if(condition3) {
					System.out.println(String.format(String.format("%s is the only state with min loan amount requirement of $3,005",statesWithAmount3005.get(0).getLabel())));
				}
			}
		}

	}

}
