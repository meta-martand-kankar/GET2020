package polynomial;

/**
 * This class performs operation on integer polynomials.
 * @author Martand
 *
 */
public class Polynomial {
	private final int[] polynomial;

	public int[] getPolynomial() {
		return polynomial.clone();
	}


	/**
	 *This constructor initializes the immutable polynomial array.
	 * @param polynomialCoeffAndDegree polynomial provided by user.
	 */
	Polynomial(int[][] polynomialCoeffAndDegree){
		int max = -1;
		for(int i =0; i<polynomialCoeffAndDegree.length;i++){
			if(max<polynomialCoeffAndDegree[i][1])
				max = polynomialCoeffAndDegree[i][1];
		}

		int[] tempArr = new int[max+1];

		for(int i = 0;i<polynomialCoeffAndDegree.length;i++){
			if(polynomialCoeffAndDegree[i][0] != 0){
				tempArr[polynomialCoeffAndDegree[i][1]] = polynomialCoeffAndDegree[i][0];
			}
		}
		polynomial = tempArr.clone();
	}


	/**
	 * This function evaluates the polynomial.
	 * @param valueOfX value of x used for evaluation
	 * @return evaluated result of polynomial.
	 */
	public float evaluatePolynomial(float valueOfX){
		float result = 0;
		for(int i = 0;i < getPolynomial().length; i++){
			if(getPolynomial()[i] != 0)
				result += getPolynomial()[i]*(float)Math.pow((double)valueOfX, (double)i);
		}
		return result;
	}

	/**
	 * This function provides the degree of polynomial.
	 * @return highest degree of polynomial.
	 */
	public int getDegreeOfPolynomial(){
		return getPolynomial().length-1;
	}

	/**
	 * This fucntion adds two polynomail.
	 * @param poly_1 first polynomial to add.
	 * @param poly_2 second polynomial to add.
	 * @return array of addition result of two polynomial.
	 */
	public static int[] addPolynomial(Polynomial poly_1,Polynomial poly_2){
		int length = (poly_1.getPolynomial().length > poly_2.getPolynomial().length)? poly_1.getPolynomial().length : poly_2.getPolynomial().length;
		int[] additionResult = new int[length];
		int i=0,j=0,k=0;

		while(i<poly_1.getPolynomial().length && j<poly_2.getPolynomial().length){
			if(poly_1.polynomial[i] != 0 || poly_2.polynomial[j] != 0)
				additionResult[k++] = poly_1.polynomial[i++] + poly_2.polynomial[j++];
		}

		while(i<poly_1.getPolynomial().length)
			if(poly_1.getPolynomial()[i] != 0)
				additionResult[k++] = poly_1.getPolynomial()[i++];
		while(j<poly_2.getPolynomial().length)
			if(poly_2.getPolynomial()[j] != 0)
				additionResult[k++] = poly_2.getPolynomial()[j++];

		return additionResult;
	}

	/**
	 * This function multiplies two polynomial.
	 * @param poly_1 first polynomial to multiply.
	 * @param poly_2 second polynomial to multiply.
	 * @return array of multiplication result of two polynomial.
	 */
	public static int[] multiplyPolynomial(Polynomial poly_1, Polynomial poly_2){
		int[] product = new int[poly_1.getPolynomial().length+poly_2.getPolynomial().length - 1];

		for(int i = 0;i<poly_1.getPolynomial().length;i++){
			for(int j = 0;j<poly_2.getPolynomial().length;j++){
				product[i+j] = poly_1.getPolynomial()[i]*poly_2.getPolynomial()[j];
			}
		}

		return product;
	}

}
