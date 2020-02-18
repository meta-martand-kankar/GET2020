package soapClient;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

import soapProject.*;

public class AreaCalculator {
	public static void main(String[] args) {
		if(args.length != 3)
			System.out.println("Pass three sides of triangle");

		TriangleServiceLocator locator = new TriangleServiceLocator();
		try {
			Triangle triangle = locator.getTriangle();
			String arr = JOptionPane.showInputDialog("Enter the sides of triangle");
			char[] input = arr.toCharArray();
			int area = triangle.calculateArea(input[0]-'0',input[1]-'0',input[2]-'0');
			JOptionPane.showMessageDialog(null, "The Area is : " + area);
		} 
		catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Web service not available : " + e.getMessage());
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
