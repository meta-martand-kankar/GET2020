package multivariatePolynomial;

import multivariatePolynomial.Variant;
import multivariatePolynomial.Term;;

/**
 * This class holds the functionalities of polynomial
 * @author Martand
 *
 */
public class Polynomial {

	private static Term header;
	private static Variant tempHead;

	/**
	 * This function is used add a new term in polynomial
	 * @param coeff of a term
	 * @param variantPower variants in a term
	 * @return true if successfullt added
	 */
	static boolean addTerm(int coeff, int ...variantPower) {
		tempHead = null;
		for(int i = 0; i < variantPower.length; i++){
			Variant newVariant = new Variant(variantPower[i]);
			if(tempHead == null){
				tempHead = newVariant;
				continue;
			}
			Variant temp = tempHead;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(newVariant);
		}

		Term newTerm = new Term(coeff, tempHead);

		if(header == null){
			header = newTerm;
			return true;
		}
		Term tempTermHead = header;
		while(tempTermHead.getNext() != null){
			tempTermHead = tempTermHead.getNext();
		}
		tempTermHead.setNext(newTerm);

		return true;
	}

	/**
	 * This function is used to display the polynomial.
	 * @return true if not empty
	 */
	static boolean display() {
		if(header == null){
			return false;
		}
		Term tempTermHead = header;

		while(tempTermHead != null){
			System.out.print(tempTermHead.getCoeff());  
			getVariantValue(tempTermHead.getVarHeader());
			System.out.print(" + ");
			tempTermHead = tempTermHead.getNext();
		}

		return true;
	}

	/**
	 * This function is used to get the power of variant for displaying.
	 * @param tempVariantHead for each term
	 * @return true if successfull
	 */
	private static boolean getVariantValue(Variant tempVariantHead) {
		char[] variant = {'X','Y','Z'};
		int counter =0;

		while(tempVariantHead != null){
			System.out.print(variant[counter++] + "^" + tempVariantHead.getPower());
			tempVariantHead = tempVariantHead.getNext();
		}

		return true;
	}

	/**
	 * this function is used find the degree of a polynomial
	 * @return degree
	 */
	static int getDegreeOfPolynimal(){
		if(header == null){
			return -1;
		}
		Term tempTermHead = header;
		int maxDegree = -1, sum;
		while(tempTermHead != null){  
			sum=0;
			Variant tempVariantHead = tempTermHead.getVarHeader();
			while(tempVariantHead != null){
				sum += tempVariantHead.getPower();
				tempVariantHead = tempVariantHead.getNext();
			}
			if(maxDegree < sum)
				maxDegree = sum;
			tempTermHead = tempTermHead.getNext();
		}
		return maxDegree;
	}
}
