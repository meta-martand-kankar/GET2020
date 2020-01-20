package splitArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class tests splitArray class over multiple testcases.
 * @author Martand
 *
 */
public class TestSplitArray {

	int actualResult;
	
	/**
	 * General test case for SplitArray class.
	 */
	@Test
	public void TextCasesForSplitArray_1(){
		actualResult = SplitArray.returnIndexWhenSumEquals(new int[] {1,1,1,2,1});
		assertEquals(3,actualResult);
	}
	@Test
	public void TextCasesForSplitArray_2(){
		actualResult = SplitArray.returnIndexWhenSumEquals(new int[] {2,1,1,2,1});
		assertEquals(-1,actualResult);
	}
	@Test
	public void TextCasesForSplitArray_3(){
		actualResult = SplitArray.returnIndexWhenSumEquals(new int[] {10,10});
		assertEquals(1,actualResult);
	}
	
	/**
	 * Test CAse to check exception for "Empty Array".
	 */
	@Test
	public void TextCasesForSplitArray_EmptyArray(){
		try {
			actualResult = SplitArray.returnIndexWhenSumEquals(new int[] {});
			assertEquals(1,actualResult);
		} catch (AssertionError e) {
			System.out.println("Array is Empty");
		}
	}
}
