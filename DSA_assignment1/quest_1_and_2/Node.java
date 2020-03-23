package linkedList;

/**
 * This class holds the structure of nodes in linked list
 * @author Martand
 *
 */
public class Node {
	private int data;
	private Node next;

	Node(int nodeValue){
		this.data = nodeValue;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
