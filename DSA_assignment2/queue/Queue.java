package queue;

/**
 * This class extends Queue Interface for circular queue implementation using array
 * @author Martand
 *
 */
public class Queue implements QueueInterface {
	private static int front = -1, rear = 0, capacity; 
	private static int[] queue; 

	Queue(int c) 
	{  
		Queue.capacity = c; 
		queue = new int[capacity]; 
	} 

	public boolean enqueue(int data) 
	{ 
		if(data == -1){
			System.out.println("-1 value not allowed");
			return false;
		}
		else if(checkOverflow()){  
			return false; 
		} 
		else if(front == -1){
			front = rear = 0; 
			queue[rear] = data; 
		}
		else if (rear == capacity-1 && front != 0) 
		{ 
			rear = 0; 
			queue[rear] = data; 
		}
		else { 
			rear++;
			queue[rear] = data;  
		} 
		return true; 
	} 

	public int dequeue() 
	{ 
		if(checkUnderflow()){ 
			return -1; 
		} 
		int temp = queue[front];
		queue[front] = -1;
		if (front == rear) 
		{ 
			front = -1; 
			rear = -1; 
		} 
		else if (front == capacity-1) 
			front = 0; 
		else
			front++;
		return temp;
	} 

	public boolean display() 
	{ 
		int i; 
		if (checkUnderflow()){ 
			return false;
		} 
		if(front <= rear)
			for (i = front; i <= rear; i++) { 
				System.out.print(queue[i] + " <-- "); 
			}
		else{
			for (i = front; i < capacity; i++) { 
				System.out.print(queue[i] + " <-- "); 
			}
			for (i = 0; i <= rear; i++) { 
				System.out.print(queue[i] + " <-- "); 
			}
		}
		System.out.println();
		return true; 
	} 

	public boolean checkUnderflow(){
		if(front == -1){
			System.out.println("Underflow"); 
			return true; 
		}
		return false;
	}

	public boolean checkOverflow(){

		if ((front == 0 && rear == capacity -1) || 
				(rear == (front-1)%(capacity -1))) 
		{ 
			System.out.println("Qverflow"); 
			return true; 
		} 
		return false;
	}
} 

