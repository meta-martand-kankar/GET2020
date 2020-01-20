package lcm;

/**
 * This class calculates LCM of two numbers.
 * @author Martand
 *
 */
public class LCM {
	private int multiplier = 2;
	private int valueToMultiply;

	/**
	 * This class calculates LCM of two numbers.
	 * @param num_1 First number for LCM
	 * @param num_2 Second number for LCM
	 * @return the LCM of two numbers.
	 * @throws ArithmeticException for divide by zero.
	 */
	public int calculateLCM(int num_1, int num_2) throws ArithmeticException{
		if(num_1==0||num_2==0)
			throw new ArithmeticException("Divide by Zero");
		int tempVar = (num_1 > num_2)? num_1:num_2;
		if(tempVar%num_1 == 0 && tempVar%num_2 == 0)
			return tempVar;
		else{
			if(multiplier==2 && tempVar == num_1){		
				valueToMultiply = num_1;
			}
			else if(multiplier ==2 && tempVar == num_2)
				valueToMultiply = num_2;
			return calculateLCM(valueToMultiply*multiplier++,(num_1%tempVar == 0)? num_2:num_1);
		}
	}
}
