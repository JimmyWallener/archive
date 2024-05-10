package se.rps;

import java.util.Random;


public class Computer {
	
	public static String computer() {
		Random generator = new Random();
		int num = generator.nextInt(2 + 1);
		String[] array = new String[] {"rock","scissors","paper"};
		return array[num];
		
		
	}

}
