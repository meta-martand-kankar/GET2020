package area;

public class Shapes {

	/**
	 * This function calculates area of triangle using formulae width*height/2.
	 * @param width, width of triangle.
	 * @param height, height of triangle. 
	 * @return area of triangle.
	 */
	public double areaOfTriangle(double width, double height){
		return (width*height)/2;
	}

	/**
	 * This function calculates area of rectangle using formulae width*height.
	 * @param width, width of rectangle.
	 * @param height, height of rectangle.
	 * @return area of rectangle.
	 */
	public double areaOfRectangle(double width, double height){
		return (width*height);
	}

	/**
	 *This function calculates area of square using formulae width*width.
	 * @param width, width of square.
	 * @param height, height of square
	 * @return area of square.
	 */	
	public double areaOfSquare(double width){
		return (width*width);
	}

	/**
	 * This function calculates the area of circle using formulae pie*(radius)^2. 	
	 * @param radius, radius of circle.
	 * @return area of circle.
	 */
	public double areaOfCircle(double radius){
		double pie = 3.14d;
		return pie*(radius*radius);
	}
}
