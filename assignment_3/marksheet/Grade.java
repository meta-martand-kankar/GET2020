package marksheet;

import java.util.*;

/**
 * This class uses Marksheet as a Utility and shows result to end user.
 * @author Martand
 *
 */
public class Grade {

	public static void main(String[] args){
		Marksheet marksheetObject = new Marksheet();
		float tempVar;
		int tempInt;
		ArrayList<Float> tempMarks = new ArrayList<Float>();

		Scanner readInp = new Scanner(System.in);
		System.out.println("Enter total no. of students");

		breakOuterLoop:
			while(true){

				while(marksheetObject.getTotalStudents() == 0){
					try {
						tempInt = readInp.nextInt();
						marksheetObject.setTotalStudents(tempInt);
						if(marksheetObject.getTotalStudents() < 0){
							System.out.println("Error : provide positive Float value");
							marksheetObject.setTotalStudents(0);
						}
					} catch (InputMismatchException e) {
						System.out.println("Error : Provide valid Floating point number");
						readInp.nextLine();
					}
				}

				while(marksheetObject.getMarks().isEmpty()){
					System.out.println("Enter the marks of Students :");
					for(int i = 0; i < marksheetObject.getTotalStudents(); i++){
						tempMarks.add(readInp.nextFloat());
					}
					marksheetObject.setMarks(tempMarks);
				}

				System.out.println("Select operation to perform : \n");
				System.out.println("1.Average of all grades\n2.Maximum Grade\n3.Minimum Grade\n4.Students passed\n5.Exit\n");
				int option = 0;
				try {
					option = readInp.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Ërror : provid valid integer value");
					readInp.nextLine();
				}

				switch(option){

				case 1:
					tempVar = marksheetObject.avgOfAllGrades();
					if(tempVar == -1f){
						System.out.println("Provide Input again");
						break;
					}
					System.out.print("Avg of all grades : ");
					System.out.println(String.format("%.2f", tempVar));
					break;

				case 2:
					tempVar = marksheetObject.maxOfAllGrades();
					if(tempVar == -1f){
						System.out.println("Provide Input again");
						break;
					}
					System.out.print("Max of all grades : ");
					System.out.println(String.format("%.2f", tempVar));
					break;

				case 3:
					tempVar = marksheetObject.minOfAllGrades();
					if(tempVar == -1f){
						System.out.println("Provide Input again");
						break;
					}
					System.out.print("Min of all grades : ");
					System.out.println(String.format("%.2f", tempVar));
					break;

				case 4:
					tempVar = marksheetObject.percentageStudentsPassed();
					if(tempVar == -1f){
						System.out.println("Provide Input again");
						break;
					}
					System.out.print("Total percentage of students passed : ");
					System.out.println(String.format("%.2f", tempVar));
					break;

				case 5:
					break breakOuterLoop;

				default:
					System.out.println("provide valid input");
				}
			}
		readInp.close();
	}
}
