package employee;

/**
 * Driver class for employee list
 * @author Martand
 *
 */
public class EmployeeOperation {

	public static void main(String[] args){
		EmployeeList emp = new EmployeeList();
		
		emp.addEmployee("test", 20000, 22);
		emp.addEmployee("chal", 23000, 25);
		emp.addEmployee("raha", 98000, 25);
		emp.addEmployee("hai", 120000, 21);
		emp.addEmployee("unique", 19000, 27);
		emp.addEmployee("name", 10000, 29);
		emp.addEmployee("chal", 23000, 20);
		emp.addEmployee("hota hai", 25000, 26);
		emp.displayList();
		System.out.println("----------------");
		emp.sortList();
		emp.displayList();
	}
}
