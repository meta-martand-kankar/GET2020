package linkedList;

import linkedList.Node;

/**
 * This class holds the functionalities of linked list
 * @author Martand
 *
 */
public class LinkedList {

	private static Node header;
	private static int linkedListLength = 0;

	/**
	 * To add new node in list
	 * @param data of node
	 * @return true if successful
	 */
	static boolean addNode(int data){
		Node newNode = new Node(data);

		if(header == null){
			header = newNode;
		}
		else{
			Node temp = header;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		linkedListLength++;
		return true;
	}
	
	/**
	 * To display the linked list
	 * @return true if list present
	 */
	static boolean displayList() {
		if(header == null){
			return false;
		}
		Node temp = header;
		while(temp != null){
			System.out.print(temp.getData() + " -> ");
			temp = temp.getNext();
		}
		return true;
	}
	
	//------------Question-1--------------
	
	/**
	 * To rotate list in clockwise direction
	 * @param leftPos of sublist
	 * @param rightPos of sublist
	 * @param steps of rotation
	 * @return true if successfully done
	 */
	static boolean rotateSublistClockwise(int leftPos, int rightPos, int steps) {
		if(header == null || linkedListLength < leftPos || linkedListLength < rightPos || rightPos < leftPos){
			return false;
		}
		if(steps == rightPos-leftPos+1 || rightPos == leftPos){
			return true;
		}
		
		Node leftPointer, rightPointer, temp = header, tempLPointer, tempRPointer ;
		int counter=1;
		while(counter != leftPos-1){
			temp = temp.getNext();
			counter++;
		}
		leftPointer = temp;
		while(counter != rightPos-steps){
			temp = temp.getNext();
			counter++;
		}
		rightPointer = temp;
		
		while(counter != rightPos){
			temp = temp.getNext();
			counter++;
		}
		tempRPointer = temp;
		
		tempLPointer = leftPointer.getNext();
		
		leftPointer.setNext(rightPointer.getNext());
		rightPointer.setNext(tempRPointer.getNext());
		tempRPointer.setNext(tempLPointer);
		
		return true;
	}
	
	//----------------Question-2-----------------
	
	/**
	 * To check loop in linked list
	 * @return true if found
	 */
	static boolean checkLoop(){
		if(header == null){
			return false;
		}
		Node temp1 = header;
		Node temp2 = header;
		
		while(temp1.getNext() != null && temp2.getNext() != null && temp2.getNext().getNext() != null){
			temp1 = temp1.getNext();
			temp2 = temp2.getNext().getNext();
			if(temp1 == temp2){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * To make loop in linked list
	 * @param left - 1st node to loop
	 * @param right last node to loop
	 */
	static void makeLoop(int left, int right){
		Node temp = header, leftPtr, rightPtr;
		int counter =1;
		while(counter != left){
			temp = temp.getNext();
			counter++;
		}
		leftPtr = temp;
		
		while(counter != right){
			temp = temp.getNext();
			counter++;
		}
		rightPtr = temp;
		
		rightPtr.setNext(leftPtr);
	}
}
