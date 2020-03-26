package counselingProgram;

/**
 * This is a structure for Students allocated course after counseling
 * @author Martand
 *
 */
public class AllotedStudents {
	private String name;
	private String course;
	
	/**
	 * To initialize the object
	 * @param stuName of student
	 * @param stuCourse alloted course
	 */
	public AllotedStudents(String stuName, String stuCourse){
		this.name = stuName;
		this.course = stuCourse;
	}

	public String getName() {
		return name;
	}

	public String getCourse() {
		return course;
	}
}
