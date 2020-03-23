package multivariatePolynomial;

import multivariatePolynomial.Variant;

/**
 * This class holds the structure of terms in polynomial
 * @author Martand
 *
 */
public class Term {
	private int coeff;
	private Variant varHeader;
	private Term next;
	
	public Term(int coeff, Variant head) {
		this.coeff = coeff;
		this.varHeader = head;
		this.next = null;
	}

	public int getCoeff() {
		return coeff;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}

	public Variant getVarHeader() {
		return varHeader;
	}

	public void setVarHeader(Variant varHeader) {
		this.varHeader = varHeader;
	}

	public Term getNext() {
		return next;
	}

	public void setNext(Term next) {
		this.next = next;
	}
}
