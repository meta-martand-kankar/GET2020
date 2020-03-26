package counselingProgram;

/**
 * This is a structure for courses available in a college for counseling 
 * @author Martand
 *
 */
public class Program {

	private String course;
	private int capacity;

	/**
	 * This is used to initialize the object
	 * @param course available in college
	 * @param capacity of course
	 */
	public Program(String course, int capacity) {
		this.course = course;
		this.capacity = capacity;
	}

	public String getCourse() {
		return course;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
}
