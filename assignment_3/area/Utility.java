package area;

import java.util.Scanner;

/**
 * This class is used to read inputs from endUser.
 * @author Martand
 *
 */
public class Utility {

	/**
	 * This class reads double input from user.
	 * @return the user input.
	 */
	public static double readDoubleInputFromUser(){
		Scanner readInp = new Scanner(System.in);		
		double userInp = readInp.nextDouble();
		return userInp;
	}

	/**
	 * this class reads int input from user.
	 * @return the user input.
	 */
	public static int readIntInputFromUser(){
		Scanner readInp = new Scanner(System.in);
		int userInp = readInp.nextInt();
		return userInp;
	}
}
