package HexaDecimal;

public class Hexa {
	String str = new String("0123456789ABCDEF");

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	/**
	 * This function checks whether the hexadecimal string is apt. or not.
	 * @param hexa1 hexadecimal string needed to validate.
	 * @return boolean true for correct and false for incorrect string respectively.
	 */
	public boolean checkValid( String hexa1 ){
		char ch;
		for ( int i=0; i<hexa1.length(); i++ ){
			ch = hexa1.charAt(i);
			if ( !( (ch>=48 && ch<=57) || (ch>=65 && ch<=70) ) )
			{
				System.out.println("Error : Enter the Valid Number");
				return false;
			}
		}
		return true;
	}

	/**
	 * This function converts hexadecimal string to decimal integer value.
	 * @param hexa1 string which is to be converted in decimal.
	 * @param base show the base in which string input is provided.
	 * @return the integer decimal value of string.
	 */
	public int hexaToDecimal(String hexa1, int base){			
		int num = 0, t=1;
		char ch;
		for ( int i = hexa1.length()-1; i >=0 ; i--)
		{
			ch = hexa1.charAt(i);
			num += str.indexOf(ch)*t;
			t=t*base;		
		}
		return num;
	}

	/**
	 * This function converts int decimal value to hexadecimal string.
	 * @param hexa1 integral value of hexadecimal.
	 * @param base shows the base value of hexa1.
	 * @return the string literal of integral hexadecimal value.
	 */
	public String decimalToHexa(int hexa1, int base){			
		String s = new String();
		int rem;
		while ( hexa1 > 0){
			rem = hexa1 % base;
			s = str.charAt(rem) + s;
			hexa1 = hexa1/ base;
		}
		return s;
	}

	/**
	 * This function adds two hexadecimal value.
	 * @param hexa1 string literal on which addition is to be performed.
	 * @param hexa2 string literal on which addition is to be performed.
	 * @param base shows base of hexa1 and hexa2 .
	 * @return string literal representation of hexadecimal result generated after addition.
	 */
	public String add(String hexa1, String hexa2, int base ){
		int num1 = hexaToDecimal(hexa1, base);
		int num2 = hexaToDecimal(hexa2, base);
		return decimalToHexa(num1 + num2, base );
	}

	/**
	 * This function subtracts two hexadecimal value.
	 * @param hexa1 string literal on which subtraction is to be performed.
	 * @param hexa2 string literal on which subtraction is to be performed.
	 * @param base shows base of hexa1 and hexa2 .
	 * @return string literal representation of hexadecimal result generated after subtraction.
	 */
	public String subtract(String hexa1, String hexa2, int base){	
		int num1 = hexaToDecimal(hexa1, base);
		int num2 = hexaToDecimal(hexa1, base);
		return decimalToHexa(Math.abs(num1 - num2), base);
	}

	/**
	 * This function multiplies two hexadecimal value.
	 * @param hexa1 string literal on which multiplication is to be performed.
	 * @param hexa2 string literal on which multiplication is to be performed.
	 * @param base shows base of hexa1 and hexa2 .
	 * @return string literal representation of hexadecimal result generated after multiplication.
	 */
	public String multiply(String hexa1, String hexa2, int base){	
		int num1 = hexaToDecimal(hexa1, base);
		int num2 = hexaToDecimal(hexa1, base);
		return decimalToHexa(num1 * num2, base);
	}

	/**
	 * This function divides two hexadecimal value.
	 * @param hexa1 string literal on which division is to be performed.
	 * @param hexa2 string literal on which division is to be performed.
	 * @param base shows base of hexa1 and hexa2 .
	 * @return string literal representation of hexadecimal result generated after addition.
	 */
	public String divide(String hexa1, String hexa2, int base){	
		int num1 = hexaToDecimal(hexa1, base);
		int num2 = hexaToDecimal(hexa1, base);
		return decimalToHexa(num1 / num2, base);
	}

	/**
	 * This function compare hexadecimal string on > , < , ==.
	 * @param hexa1 string literal on which comparison is to be performed
	 * @param hexa2 string literal on which comparison is to be performed
	 */
	public void compare(String hexa1, String hexa2){
		int len1 = hexa1.length()-1;
		int len2 = hexa2.length()-1;
		if ( len1 > len2 )
			System.out.println(hexa1+ " is greater than "+ hexa2);
		else if( len1 < len2)
			System.out.println(hexa1+ " is less than "+ hexa2);
		else if( hexa1.equals(hexa2))
			System.out.println(hexa1+ " is equal to "+ hexa2);
		else if ( len1 == len2){
			for ( int i=0; i < len1; i++){
				if ( hexa1.charAt(i) == hexa2.charAt(i) )
					continue;
				if ( hexa1.charAt(i) > hexa2.charAt(i)){
					System.out.println(hexa1+ " is greater than "+ hexa2);
					break;
				}
				else{
					System.out.println(hexa1+ " is less than "+ hexa2);
					break;
				}
			}

		}
	}
}
