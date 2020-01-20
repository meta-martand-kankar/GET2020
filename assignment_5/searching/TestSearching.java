package searching;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests class Searching on multiple tests cases.
 * @author Martand
 *
 */
public class TestSearching {
	int actualResult;

	//Test cases for Linear Search.
	@Test
	public void TestCaseForLinearSearch(){
		Searching searchObj = new Searching();
		actualResult = searchObj.findElementUsingLinearSearch(new int[] {4,5,6,2,3,45,65,7,1,1,8,9},45);
		assertEquals(6,actualResult);
	}
	//Test Case for element not present in array.
	@Test
	public void TestCaseForLinearSearch1(){
		Searching searchObj = new Searching();
		actualResult = searchObj.findElementUsingLinearSearch(new int[] {4,5,6,2,3,45,65,7,1,1,8,9},99);
		assertEquals(-1,actualResult);
	}

	//Test Cases For Binary Search.
	@Test
	public void TestCaseForBinarySearch(){
		Searching searchObj = new Searching();
		actualResult = searchObj.findElementUsingBinarySearch(new int[] {1,2,3,4,5,6,7,8,9},9);
		assertEquals(9,actualResult);
	}
	@Test
	public void TestCaseForBinarySearch1(){
		Searching searchObj = new Searching();
		actualResult = searchObj.findElementUsingBinarySearch(new int[] {1,2,3,6,7,8,9},5);
		assertEquals(-1,actualResult);
	}
	@Test
	public void TestCaseForBinarySearch2(){
		Searching searchObj = new Searching();
		actualResult = searchObj.findElementUsingBinarySearch(new int[] {1,2,3,6,7,8,9},0);
		assertEquals(-1,actualResult);
	}
	@Test
	public void TestCaseForBinarySearch3(){
		Searching searchObj = new Searching();
		actualResult = searchObj.findElementUsingBinarySearch(new int[] {1,2,3,6,7,8,9},10);
		assertEquals(-1,actualResult);
	}
}
