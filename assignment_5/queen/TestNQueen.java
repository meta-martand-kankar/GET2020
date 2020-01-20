package queen;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class test the Queen class over test cases;
 * @author Martand
 *
 */
public class TestNQueen {

	/**
	 * This function tests the class Queen for 4*4 matrix.
	 */
	@Test
	public void testForFourQueens() {
		int n = 4;

		int [][] board = new int[n][n];
		boolean res = Queen.nQueenSolution(board , 0, n);
		assertEquals(true,res);
	}

}
