package marksheet;

import java.util.*;

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

	int totalStudents;
	ArrayList<Float> marks = new ArrayList<Float>();

	/**
	 * 	This function calculates the average grade of class.
	 * @return average of all grades present in ArrayList marks;
	 */
	public float avgOfAllGrades(){
		float sum = 0;
		for(int i = 0; i < totalStudents; i++){
			sum += marks.get(i);
		}
		return (sum/totalStudents);
	}

	/**
	 * 	This function finds the maximum marks obtained among student.
	 * @return maximum marks obtained by student in class.
	 */
	public float maxOfAllGrades(){
		Collections.sort(marks);
		return marks.get(totalStudents-1);
	}

	/**
	 * 	This function finds minimum marks obtained among students.
	 * @return minimum marks obtained by student in ArrayList marks;
	 */
	public float minOfAllGrades(){
		Collections.sort(marks);
		return marks.get(0);
	}

	/**
	 * 	This function calculates percentage of students who passed in exam.
	 * @return total percentage of students who scored above passing marks;
	 */
	public float percentageStudentsPassed(){
		float passingMark = 40.00f;
		int counter = 0;
		Collections.sort(marks);
		for(counter = 0; counter < totalStudents; counter++){
			if(marks.get(counter) >= passingMark){
				break;
			}
		}
		return (totalStudents - counter)*100/totalStudents;
	}
}
