package polynomial;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * This class tests the class Polynomial over multiple test cases.
 * @author Martand
 *
 */
public class TestPolynomial {

	@Test
	public void testPolynomial_evaluatePolynomial(){
		int[][] a ={{2,3},{2,2},{5,0}};
		Polynomial obj = new Polynomial(a);
		float result = obj.evaluatePolynomial(2);
		assertEquals(29.0,result, 0.001);
	}

	@Test
	public void testPolynomial_GetDegreeOfPolynomial(){
		int[][] a ={{2,3},{2,2},{5,0}};
		Polynomial obj = new Polynomial(a);
		int result = obj.getDegreeOfPolynomial();
		assertEquals(3,result);
	}

	@Test
	public void testPolynomial_addPolynomial(){
		int[][] a ={{2,3},{2,2},{5,0}};
		Polynomial obj = new Polynomial(a);
		a[0][0] = 2;
		a[0][1] = 1;
		a[1][0] = 4;
		a[1][1] = 2;
		Polynomial obj_2 = new Polynomial(a);
		int[] result = Polynomial.addPolynomial(obj, obj_2);
		assertArrayEquals(new int[] {10,2,6,2},result);
	}

	@Test
	public void testPolynomial_multiplyPolynomial(){
		int[][] a ={{2,3},{2,2},{5,0}};
		Polynomial obj = new Polynomial(a);
		a[0][0] = 2;
		a[0][1] = 1;
		a[1][0] = 4;
		a[1][1] = 2;
		Polynomial obj_2 = new Polynomial(a);
		int[] result = Polynomial.multiplyPolynomial(obj, obj_2);
		assertArrayEquals(new int[] {25,0,10,10,4,8},result);
	}
}
