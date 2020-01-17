package stringOperations;

import java.util.*;

/**
 * This class uses StringUtility and also uses its method in accordance of end user.
 * @author Martand
 *
 */
public class OperationsOnString {

	public static void main(String[] args){
		String str_1 = new String();
		String str_2 = new String();

		Scanner readInp = new Scanner(System.in);

		breakOuterLoop:
			while(true){
				System.out.println("Select operation to perform : \n");
				System.out.println("1.Compare Two Strings\n2.Reverse String\n3.Change Case\n4.Largest Word In String\n");
				int option = readInp.nextInt();
				readInp.nextLine();
				switch(option){

				case 1:
					System.out.println("Enter 1st String for compare :  ");
					str_1 = readInp.nextLine();
					System.out.println("Enter 2nd String for compare :  ");
					str_2 = readInp.nextLine();
					int result = StringUtility.compareStrings(str_1, str_2);
					if(result == 1){
						System.out.println("The strings provided are equal.");
					}
					else{
						System.out.println("The strings provided are not equal.");
					}
					break;

				case 2:
					System.out.println("Enter 1st String for compare :  ");
					str_1 = readInp.nextLine();
					System.out.println("Reversed string is : " + StringUtility.reverseString(str_1));
					break;

				case 3:
					System.out.println("Enter 1st String for compare :  ");
					str_1 = readInp.nextLine();
					System.out.println("After changing case : " + StringUtility.changeCase(str_1));
					break;

				case 4:
					System.out.println("Enter 1st String for compare :  ");
					str_1 = readInp.nextLine();
					System.out.println("Largest word last index : " + StringUtility.largestWord(str_1));
					break;

				case 5:
					break breakOuterLoop;
				}
			}
		readInp.close();
	}
}
