package counselingProgram;

/**
 * This class holds structure of student for counseling program
 * @author Martand
 *
 */
public class Student {

	private String name;
	private String[] preferedCourses;

	/**
	 * To initialize object
	 * @param stuName name of student
	 * @param stuCourses preferred courses by student
	 */
	public Student(String stuName, String[] stuCourses){
		this.name = stuName;
		this.preferedCourses = stuCourses;
	}

	public String getName() {
		return name;
	}

	public String[] getPreferedCourses() {
		return preferedCourses;
	}
}
