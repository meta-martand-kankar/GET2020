package lcm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests classes LCM and HCF on multiple tests cases.
 * @author Martand
 *
 */
public class TestLCMAndHCF {
	int actualResult;
	//Test cases for HCF class.

	/**
	 * General Test cases for HCF class.
	 */
	@Test
	public void TestCaseForHCF(){
		HCF hcf = new HCF();
		actualResult = hcf.calculateHCFUsingEuclids(24, 36);
		assertEquals(12,actualResult);
	}
	@Test
	public void TestCaseForHCF_1(){
		HCF hcf = new HCF();
		actualResult = hcf.calculateHCFUsingEuclids(910, 42);
		assertEquals(14,actualResult);
	}

	/**
	 * Test case for divide by zero exception.
	 */
	@Test
	public void TestCaseForHCF_DivideByZero(){
		HCF hcf = new HCF();
		try {
			actualResult = hcf.calculateHCFUsingEuclids(0, 36);
			assertEquals(8,actualResult);
		} catch (ArithmeticException e) {
			System.out.println("Divide By Zero");
		}
	}

	//Test cases for LCM class.

	/**
	 * General test cases for Lcm class.
	 */
	@Test
	public void TestCaseForLCM(){
		LCM lcmObject = new LCM();
		actualResult = lcmObject.calculateLCM(4,8);
		assertEquals(8,actualResult);
	}
	@Test
	public void TestCaseForLCM1(){	
		LCM lcmObject = new LCM();
		actualResult = lcmObject.calculateLCM(3,8);
		assertEquals(24,actualResult);
	}
	@Test
	public void TestCaseForLCM2(){
		LCM lcmObject = new LCM();
		actualResult = lcmObject.calculateLCM(30,45);
		assertEquals(90,actualResult);
	}

	/**
	 * Test case on exception for Divide by zero.
	 */
	@Test
	public void TestCaseForLCM_DivideByZero(){
		LCM lcmObject = new LCM();
		try {
			actualResult = lcmObject.calculateLCM(0,8);
			assertEquals(8,actualResult);
		} catch (ArithmeticException e) {
			System.out.println("Divide By Zero");
		}
	}
}
