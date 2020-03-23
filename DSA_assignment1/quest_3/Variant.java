package multivariatePolynomial;

/**
 * This calss holds the structure of variants in polynomial
 * @author Martand
 *
 */
public class Variant {
	private int power;
	private Variant next;

	public Variant(int pow) {
		this.power = pow;
		next = null;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public Variant getNext() {
		return next;
	}

	public void setNext(Variant next) {
		this.next = next;
	}


}
