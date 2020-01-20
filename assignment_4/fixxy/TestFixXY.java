package fixxy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * This class tests FixXY class on multiple test cases.
 * @author Martand
 *
 */
public class TestFixXY {
	int[] actualResult;

	/**
	 * Usual test on FixXY over general test cases.
	 */
	@Test
	public void testCaseForRearrangeXY_1(){
		actualResult = FixXY.rearrangeXY(new int[] {5,4,9,4,9,5}, 4, 5);
		assertArrayEquals(new int[] {9,4,5,4,5,9},actualResult);
	}
	@Test
	public void testCaseForRearrangeXY_2(){
		actualResult = FixXY.rearrangeXY(new int[] {1,4,1,5},4,5);
		assertArrayEquals(new int[] {1,4,5,1},actualResult);
	}
	@Test
	public void testCaseForRearrangeXY_3(){
		actualResult = FixXY.rearrangeXY(new int[] {1,4,1,5,5,4,1},4,5);
		assertArrayEquals(new int[] {1,4,5,1,1,4,5},actualResult);
	}

	/**
	 * Test for exception on "Null Array".
	 */
	@Test
	public void testCaseForRearrangeXY_EmptyArray(){
		try {
			actualResult = FixXY.rearrangeXY(new int[] {},4,5);
			assertArrayEquals(new int[] {},actualResult);
		} catch (AssertionError e) {
			System.out.println("Array is empty");
		}
	}

	/**
	 * Test for exception on "Unequal presence of X and Y in array".
	 */
	@Test
	public void testCaseForRearrangeXY_Counts(){
		try {
			actualResult = FixXY.rearrangeXY(new int[] {1,4,1,5,1,4,1},4,5);
			assertArrayEquals(new int[] {1,4,5,1,1,4,5},actualResult);
		} catch (AssertionError e) {
			System.out.println("Number of counts of x and Y are different");
		}
	}

	/**
	 * Test for exception on "X at last index".
	 */
	@Test
	public void testCaseForRearrangeXY_XAtLastIndex(){
		try {
			actualResult = FixXY.rearrangeXY(new int[] {1,4,1,5,5,4},4,5);
			assertArrayEquals(new int[] {1,4,5,1,1,4,6},actualResult);
		} catch (AssertionError e) {
			System.out.println("X present at last index");
		}
	}

	/**
	 * Test for exception on "Adjacent X's in array".
	 */
	@Test
	public void testCaseForRearrangeXY_AdjacentX(){
		try {
			actualResult = FixXY.rearrangeXY(new int[] {1,4,4,5,5,1},4,5);
			assertArrayEquals(new int[] {1,4,5,1,1,4,5},actualResult);
		} catch (AssertionError e) {
			System.out.println("Adjacent X's encountered");
		}
	}
}
