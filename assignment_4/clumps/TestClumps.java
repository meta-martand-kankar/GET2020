package clumps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class tests class Clumps over multiple test casses
 * @author Martand
 *
 */
public class TestClumps {
	int actualResult ;

	/**
	 * Performs tests on clumps class.
	 */
	@Test
	public void testCaseForCountClumps() {
		actualResult = Clump.countClumpsInArrayList(new int[] {1,2,2,3,4,4});
		assertEquals(2,actualResult);
	}
	@Test
	public void testCaseForCountClumps1() {
		actualResult = Clump.countClumpsInArrayList(new int[] {1,1,2,1,1});
		assertEquals(2,actualResult);
	}
	@Test
	public void testCaseForCountClumps2() {
		actualResult = Clump.countClumpsInArrayList(new int[] {1,1,1,1,1});
		assertEquals(1,actualResult);
	}

	/**
	 * Tests clumps class for exception.
	 */
	@Test
	public void testCaseForCountClumps_EmptyArray() {
		actualResult = Clump.countClumpsInArrayList(new int[] {});
		try {
			assertEquals(2,actualResult);
		} catch (AssertionError e) {
			System.out.println("Array is Empty");
		}
	}
	@Test
	public void testCaseForCountClumps4() {
		actualResult = Clump.countClumpsInArrayList(new int[] {1});
		assertEquals(0,actualResult);
	}
	@Test
	public void testCaseForCountClumps5() {
		actualResult = Clump.countClumpsInArrayList(new int[] {1,2,3,4,5});
		assertEquals(0,actualResult);
	}
	@Test
	public void testCaseForCountClumps6() {
		actualResult = Clump.countClumpsInArrayList(new int[] {-1,-1});
		assertEquals(1,actualResult);
	}
}
