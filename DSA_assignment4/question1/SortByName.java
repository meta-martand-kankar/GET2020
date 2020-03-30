package employee;

import java.util.Comparator;

/**
 * This overwrites compare for sorting by name
 * @author Martand
 *
 */
public class SortByName implements Comparator<EmployeeDetail> {

	public int compare(EmployeeDetail a, EmployeeDetail b) {
		return a.getName().compareTo(b.getName()); 
	}
}
