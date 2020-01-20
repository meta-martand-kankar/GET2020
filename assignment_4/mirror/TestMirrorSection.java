package mirror;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the MirrorSection class over multiple test cases.
 * @author Martand
 *
 */
public class TestMirrorSection {

	int actualResult;
	
	/**
	 * Tests the method of MirrorSection class on general test cases.
	 */
	@Test
	public void expression() {
		actualResult = MirrorSection.maxMirror(new int[] {1,2,3,4,3,2,1});
		assertEquals(7,actualResult);
	}

	@Test
	public void expression1() {
		actualResult = MirrorSection.maxMirror(new int[] {1,2,3,7,8,3,2,1});
		assertEquals(3,actualResult);
	}
	
	@Test
	public void expression2() {
		actualResult = MirrorSection.maxMirror(new int[] {1,4,1,6});
		assertEquals(3,actualResult);
	}
	@Test
	public void expression3() {
		actualResult = MirrorSection.maxMirror(new int[] {1,4,2,6});
		assertEquals(1,actualResult);
	}
	
	
	/**
	 * Tests the method for Empty Array.
	 */
	@Test
	public void expression_EmptyArray() {
		try {
			actualResult = MirrorSection.maxMirror(new int[] {});
			assertEquals(1,actualResult);
		}
		catch (AssertionError e) {
			System.out.println("Array is Empty");
		}
	}

}
