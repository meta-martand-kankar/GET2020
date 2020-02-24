package soapProject;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Shape {

	@WebMethod
	public abstract int calculateArea(int a, int b, int c);

}