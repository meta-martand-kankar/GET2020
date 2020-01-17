package marksheet;

import java.util.*;

/**
 * This class hold the marks using ArrayList and all the operation performed on marks.
 * @author Martand
 *
 */
public class Marksheet {
	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public ArrayList<Float> getMarks() {
		return marks;
	}

	public void setMarks(ArrayList<Float> marks) {
		this.marks = marks;
	}

	private int totalStudents;
	private ArrayList<Float> marks = new ArrayList<Float>();

	/**
	 * 	This function calculates the average grade of class.
	 * @return average of all grades present in ArrayList marks;
	 */
	public float avgOfAllGrades(){
		float sum = 0f, average= -1f;
		for(int i = 0; i < totalStudents; i++){
			sum += marks.get(i);
		}
		try{
			average = (sum/totalStudents);
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic Exception Arrived");
		}
		return average;
	}

	/**
	 * 	This function finds the maximum marks obtained among student.
	 * @return maximum marks obtained by student in class.
	 */
	public float maxOfAllGrades(){
		try{
			Collections.sort(marks);
			return marks.get(totalStudents-1);
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic Exception Arrived");
			return -1f;
		}
	}

	/**
	 * 	This function finds minimum marks obtained among students.
	 * @return minimum marks obtained by student in ArrayList marks;
	 */
	public float minOfAllGrades(){
		try{
			Collections.sort(marks);
			return marks.get(0);
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic Exception Arrived");
			return -1f;
		}

	}

	/**
	 * 	This function calculates percentage of students who passed in exam.
	 * @return total percentage of students who scored above passing marks;
	 */
	public float percentageStudentsPassed(){
		float passingMark = 40.00f, percentPassed = -1f;
		int counter = 0;
		Collections.sort(marks);
		for(counter = 0; counter < totalStudents; counter++){
			if(marks.get(counter) >= passingMark){
				break;
			}
		}
		try {
			percentPassed = (totalStudents - counter)*100/totalStudents;
		} catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception Arrived");
			percentPassed = -1f;
		}
		return percentPassed;
	}
}
