package com.upgrade.util;

import java.util.Random;

public class Utility {

	public String RandomNumbers(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		int number =r.nextInt((max - min) + 1) + min;
		
		return String.valueOf(number);
	}

	public String dob() {

		int M = (int) Math.floor(Math.random() * (1 - 12 + 1) + 12);
		String Month = String.valueOf(M);

		int D = (int) Math.floor(Math.random() * (1 - 31 + 1) + 31);
		String Day = String.valueOf(D);

		int Y = (int) Math.floor(Math.random() * (1930 - 2000 + 1) + 2000);

		if (Month != "10" || Month != "11" || Month != "12") {

			Month = "0" + Month;

			if ((Month == "02") && (Day == "29") || (Day == "30") || (Day == "31")) {

				D = (int) Math.floor(Math.random() * (1 - 28 + 1) + 28);
				Day = String.valueOf(D);

				if ((Month == "04") || (Month == "06") || (Month == "09") || (Month == "11") && (Day == "31")) {

					D = (int) Math.floor(Math.random() * (1 - 30 + 1) + 30);
					Day = String.valueOf(D);

				}
			}

		}

		String Birth = Month + " " + Day + " " + Y;

		return Birth;
	}

}
