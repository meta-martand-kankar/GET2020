package soapProject;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Triangle implements Shape {
	/* (non-Javadoc)
	 * @see soapProject.Shape#calculateArea(int, int, int)
	 */
	@Override
	@WebMethod
	public int calculateArea(int a,int b,int c) {
		int s = (a+b+c)/2;
		return (int)Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
}
