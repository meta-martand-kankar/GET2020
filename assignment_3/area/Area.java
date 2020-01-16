package area;

import java.util.Scanner;

public class Area {
	public static void main(String[] args){
		Shapes shapesObject = new Shapes();
		double height,width,radius,calculatedArea;

		Scanner readInp = new Scanner(System.in);

		breakOuterLoop:
			while(true){
				System.out.println("Select operation to perform : \n");
				System.out.println("1.Area of Triangle\n2.Area of Rectangle\n3.Area of Square\n4.Area of circless\n5.Exit\n");
				int option = readInp.nextInt();
				readInp.nextLine();
				switch(option){

				case 1:
					System.out.println("enter the width of triangle :");
					width = readInp.nextDouble();
					System.out.println("enter the height of triangle :");
					height = readInp.nextDouble();
					calculatedArea = shapesObject.areaOfTriangle(width,height);
					System.out.print("Area of Triagle : ");
					System.out.println(String.format("%.2f", calculatedArea));
					break;

				case 2:
					System.out.println("enter the width of rectangle :");
					width = readInp.nextDouble();
					System.out.println("enter the height of rectangle :");
					height = readInp.nextDouble();
					calculatedArea = shapesObject.areaOfRectangle(width, height);
					System.out.print("Area of Rectangle : ");
					System.out.println(String.format("%.2f", calculatedArea));
					break;

				case 3:
					System.out.println("enter the width of square :");
					width = readInp.nextDouble();
					calculatedArea = shapesObject.areaOfSquare(width);
					System.out.print("Area of Square : ");
					System.out.println(String.format("%.2f", calculatedArea));
					break;

				case 4:
					System.out.println("enter the radius of circle :");
					radius = readInp.nextDouble();
					calculatedArea = shapesObject.areaOfCircle(radius);
					System.out.print("Area of circle : ");
					System.out.println(String.format("%.2f", calculatedArea));
					break;

				case 5:
					break breakOuterLoop;

				default:
					System.out.println("provide valid input");
				}
			}
		readInp.close();
	}
}
