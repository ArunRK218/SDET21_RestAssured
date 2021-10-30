package sdet21.GenericUtility;

import java.util.Random;

/**
 * This class has generic methods related to java libarary
 * @author ARUN R
 *
 */
public class JavaUtility {
	
		
	public int getRandomNumber() {
		Random ran = new Random();
		int random = ran.nextInt(100);
		return random;
	}

}
