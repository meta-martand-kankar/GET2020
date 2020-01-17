package area;

/**
 * This class calculates the area of different types of objects.
 * @author Martand
 *
 */
public class Shapes {

	/**
	 * This function calculates area of triangle using formulae width*height/2.
	 * @param width, width of triangle.
	 * @param height, height of triangle. 
	 * @return area of triangle.
	 */
	public static double areaOfTriangle(double width, double height){
		double area = -1d;
		try {
			area = (width*height)/2;
		} catch (ArithmeticException e) {
			System.out.println("Error : Arithmetic Exception Arrived");
			area = -1d;
		}
		return area;
	}

	/**
	 * This function calculates area of rectangle using formulae width*height.
	 * @param width, width of rectangle.
	 * @param height, height of rectangle.
	 * @return area of rectangle.
	 */
	public static double areaOfRectangle(double width, double height){
		double area = -1d;
		try {
			area = (width*height);
		} catch (ArithmeticException e) {
			System.out.println("Error : Arithmetic Exception Arrived");
			area = -1d;
		}
		return area;
	}

	/**
	 *This function calculates area of square using formulae width*width.
	 * @param width, width of square.
	 * @param height, height of square
	 * @return area of square.
	 */	
	public static double areaOfSquare(double width){
		double area = -1d;
		try {
			area = (width*width);
		} catch (ArithmeticException e) {
			System.out.println("Error : Arithmetic Exception Arrived");
			area = -1d;
		}
		return area;
	}

	/**
	 * This function calculates the area of circle using formulae pie*(radius)^2. 	
	 * @param radius, radius of circle.
	 * @return area of circle.
	 */
	public static double areaOfCircle(double radius){
		double pie = 3.14d, area = -1d;
		try {
			area = pie*(radius*radius);
		} catch (ArithmeticException e) {
			System.out.println("Error : Arithmetic Exception Arrived");
			area = -1d;
		}
		return area;
	}
}
