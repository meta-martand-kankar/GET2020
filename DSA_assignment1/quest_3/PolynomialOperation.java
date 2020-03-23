package multivariatePolynomial;

import multivariatePolynomial.Polynomial;

/**
 * This class is for testing the polynomial utility class
 * @author Martand
 *
 */
public class PolynomialOperation {
	
	public static void main(String[] args){
		int[] a = {2,1,0};
		System.out.println(Polynomial.addTerm(3,a));
		int[] b = {1,2,1};
		System.out.println(Polynomial.addTerm(1,b));
		int[] c = {3,1,3};
		System.out.println(Polynomial.addTerm(4,c));
		
		Polynomial.display();
		
		System.out.println("\n" + Polynomial.getDegreeOfPolynimal());
	}
}
