package linkedList;

import linkedList.LinkedList;

/**
 * This class is used to test the linkedList utility class
 * @author Martand
 *
 */
public class LinkedListOperation {

	public static void main(String[] args){
		LinkedList.addNode(2);
		LinkedList.addNode(3);
		LinkedList.addNode(4);
		LinkedList.addNode(5);
		LinkedList.addNode(6);
		LinkedList.addNode(7);
		LinkedList.addNode(8);
		System.out.println(LinkedList.displayList());
		System.out.println(LinkedList.rotateSublistClockwise(2,5,2));
		LinkedList.displayList();
		System.out.println();
		System.out.println(LinkedList.checkLoop());
		LinkedList.makeLoop(2,5);
		System.out.println(LinkedList.checkLoop());
	}
}
