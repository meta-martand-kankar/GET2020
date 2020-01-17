package area;

/**
 * This class uses uses Shapes and Utility class to perform operations in accordance of end user.
 * @author Martand
 *
 */
public class Area {
	public static void main(String[] args){
		double height,width,radius,calculatedArea;
		
		breakOuterLoop:
			while(true){
				System.out.println("Select operation to perform : \n");
				System.out.println("1.Area of Triangle\n2.Area of Rectangle\n3.Area of Square\n4.Area of circless\n5.Exit\n");
				int option = Utility.readIntInputFromUser();
				switch(option){

				case 1:
					System.out.println("enter the width of triangle :");
					width = Utility.readDoubleInputFromUser();
					System.out.println("enter the height of triangle :");
					height = Utility.readDoubleInputFromUser();
					calculatedArea = Shapes.areaOfTriangle(width,height);
					if(calculatedArea == -1){
						System.out.println("Provide Input again");
						break;
					}
					System.out.print("Area of Triagle : ");
					System.out.println(String.format("%.2f", calculatedArea));
					break;

				case 2:
					System.out.println("enter the width of rectangle :");
					width = Utility.readDoubleInputFromUser();
					System.out.println("enter the height of rectangle :");
					height = Utility.readDoubleInputFromUser();
					calculatedArea = Shapes.areaOfRectangle(width, height);
					if(calculatedArea == -1){
						System.out.println("Provide Input again");
						break;
					}
					System.out.print("Area of Rectangle : ");
					System.out.println(String.format("%.2f", calculatedArea));
					break;

				case 3:
					System.out.println("enter the width of square :");
					width = Utility.readDoubleInputFromUser();
					calculatedArea = Shapes.areaOfSquare(width);
					if(calculatedArea == -1){
						System.out.println("Provide Input again");
						break;
					}
					System.out.print("Area of Square : ");
					System.out.println(String.format("%.2f", calculatedArea));
					break;

				case 4:
					System.out.println("enter the radius of circle :");
					radius = Utility.readDoubleInputFromUser();
					calculatedArea = Shapes.areaOfCircle(radius);
					if(calculatedArea == -1){
						System.out.println("Provide Input again");
						break;
					}
					System.out.print("Area of circle : ");
					System.out.println(String.format("%.2f", calculatedArea));
					break;

				case 5:
					break breakOuterLoop;

				default:
					System.out.println("provide valid input");
				}
			}
	}
}
