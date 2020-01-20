package lcm;

/**
 * This class calculates HCF of two numbers.
 * @author Martand
 *
 */
public class HCF {
	private int a,b,r=1;

	/**
	 * This class calculates HCF of two numbers using euclids algorithm.
	 * @param num_1 First number for HCF
	 * @param num_2 Second number for HCF
	 * @return the HCF of two numbers.
	 * @throws ArithmeticException for divide by zero.
	 */
	public int calculateHCFUsingEuclids(int num_1, int num_2) throws ArithmeticException{
		b = ((a = (num_1>num_2)?num_1:num_2)==num_1)?num_2:num_1;
		if(b==0&&r!=0)
			throw new ArithmeticException("Divide by Zero");
		else if(b==0 && r==0)
			return a;
		else{
			r=a%b;
			return calculateHCFUsingEuclids(b,r);
		}
	}
}
