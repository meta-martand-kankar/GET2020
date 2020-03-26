package counselingProgram;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * This is driver class for counseling program
 * @author Martand
 *
 */
public class CounselingOperation {

	public static void main(String[] args) throws IOException, WriteException, BiffException {
		Counseling.addProgram();
		Counseling.addStudent();
		Counseling.allocate();
		Counseling.addToExcel();
	}
}
