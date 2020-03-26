package stack;

/**
 * Driver class for Stack
 * @author Martand
 *
 */
public class StackOperation {
	public static void main(String[] args){
		String exp = "1+2*(3*4-5)-6";
		System.out.println(Stack.evaluate(exp));
	}
}
