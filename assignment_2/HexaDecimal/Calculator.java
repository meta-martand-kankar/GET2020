package HexaDecimal;

import java.util.*;

public class Calculator {

	public static void main(String []args){
		Hexa obj = new Hexa();
		Scanner readInp = new Scanner(System.in);
		int num1 = 0, num2 = 0;
		System.out.println("Enter the Base value: ");
		int base = readInp.nextInt();

		breakOuterLoop:
			while(true){
				System.out.println("Enter First Hexa Decimal Number: ");
				String hexa1, hexa2;			
				while (true){
					hexa1 = readInp.next().toUpperCase();
					if ( obj.checkValid( hexa1 ) )
						break;
				}

				System.out.println("Enter Second Hexa Decimal Number: ");
				while (true){
					hexa2 = readInp.next().toUpperCase();
					if ( obj.checkValid( hexa2 ) )
						break;
				}

				System.out.println("\nselect your operation:\n1. Add\n2. Subtact\n3. Multiply\n4. Divide\n5. Decimal to Hexadecimal\n6. Hexadecimal to Decimal\n7. compare Hexadecimal Numbers\n8. Exit\n");

				int num = 0;
				try {
					num = readInp.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Error : Provide positive integral value");
				}

				switch(num){

				case 1:
					System.out.println("Addition of two hex: "+ obj.add(hexa1, hexa2, base));
					break;

				case 2: 
					System.out.println("Subtract of two hex: "+ obj.subtract(hexa1, hexa2, base));
					break;

				case 3: 
					System.out.println("Multiply of two hex: "+ obj.multiply(hexa1, hexa2, base));
					break;

				case 4: 
					System.out.println("Divide of two hex: "+ obj.divide(hexa1, hexa2, base));
					break;

				case 5: 
					System.out.println("Decimal to Hexadecimal: ");
					num1 = obj.hexaToDecimal(hexa1, base);
					num2 = obj.hexaToDecimal(hexa2, base);
					System.out.println("First Number: "+ num1 + " hexa ->" + obj.decimalToHexa(num1, base)); 
					System.out.println("Second Number: "+ num2 + " hexa ->" + obj.decimalToHexa(num2, base)); 
					break;

				case 6: 
					System.out.println("Hexadecimal to Decimal: ");
					System.out.println("First Number: "+ obj.hexaToDecimal(hexa1, base)); 
					System.out.println("Second Number: "+ obj.hexaToDecimal(hexa2, base)); 
					break;

				case 7: 
					obj.compare(hexa1, hexa2);
					break;

				case 8: 
					break breakOuterLoop;

				default: 
					System.out.println("Error : Enter valid Integer ");
					break;
				}

			}
		readInp.close();
	}

}


