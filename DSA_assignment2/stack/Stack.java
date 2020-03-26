package stack;

import java.util.ArrayList;

/**
 * This class holds structure of stack and evaluates a infix arithmetic expression
 * @author Martand
 *
 */
public class Stack {
	private static ArrayList<Character> stack = new ArrayList<Character>();
	private static ArrayList<Integer> intStack = new ArrayList<Integer>();
	private static String postfixResult = "";

	/**
	 * To check the precedence of a operator
	 * @param ch to be checked
	 * @return preference
	 */
	private static int precedence(char ch){
		if (ch == '+' || ch == '-')
			return 1;
		else if (ch == '*' || ch == '/')
			return 2;
		else if (ch == '^')
			return 3;
		return -1;
	}

	/**
	 * Refers to the top element in stack
	 * @return value at top of stack
	 */
	private static char peek() {
		return stack.get(stack.size()-1);
	}

	/**
	 * Converts infix expression to postfix for evaluation
	 * @param exp to converted
	 * @return true if successful conversion
	 */
	private static boolean infixToPostfixOperation(String exp) {
		int countparenthsis = 0;
		for (int i=0; i<exp.length(); i++){
			char ch = exp.charAt(i);
			if (Character.isDigit(ch))
				postfixResult += ch;
			else{
				if (ch == '('){
					push(ch);
					countparenthsis++;
				}
				else if (ch == ')'){
					while (!stack.isEmpty() && peek() != '(')
						postfixResult += pop();
					pop();
					countparenthsis--;
				}
				else{
					while (!stack.isEmpty() && precedence(ch) <= precedence(peek()))
						postfixResult += pop();
					push(ch);
				}
			}
		}
		while (!stack.isEmpty())
			postfixResult += pop();

		if (countparenthsis != 0){
			System.out.println("invalid expression");
			return false;
		}
		return true;
	}

	/**
	 * Deletes top element from stack
	 * @return deleted element
	 */
	public static char pop() {
		char ch = peek();
		stack.remove(stack.size()-1);
		return ch;
	}

	/**
	 * Adds new element in stack
	 * @param ch to be added
	 */
	public static void push(char ch) {
		stack.add(ch);
	}

	/**
	 * Refers to top element in intStack
	 * @return top element
	 */
	private static int peekInt() {
		return intStack.get(intStack.size()-1);
	}

	/**
	 * Deletes top element
	 * @return deleted value
	 */
	public static int popInt() {
		int ch = peekInt();
		intStack.remove(intStack.size()-1);
		return ch;
	}


	/**
	 * Adds new element to intStack
	 * @param ch to be added
	 */
	public static void pushInt(int ch) {
		intStack.add(ch);
	}

	/**
	 * Evaluates infix arithmetic expression
	 * @param exp to be evaluated
	 * @return result
	 */
	public static int evaluate(String exp) {
		infixToPostfixOperation(exp);
		System.out.println("postfix : " + postfixResult);
		for (int i=0; i<postfixResult.length(); i++){
			char ch = postfixResult.charAt(i);
			if (Character.isDigit(ch))
				pushInt(Integer.valueOf(ch)-'0');
			else{
				int val1 = popInt();
				int val2 = popInt();
				System.out.println(val1 + " " + val2 );
				if (ch == '+')
					pushInt(val1 + val2);
				else if (ch == '-')
					pushInt(Math.abs(val1 - val2));
				else if (ch == '*')
					pushInt(val1 * val2);
				else
					pushInt(val1 / val2);
			}
		}
		return popInt();
	}

}
