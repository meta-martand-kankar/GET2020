package queue;

/**
 * This is the driver class for circular queue
 * @author Martand
 *
 */
public class QueueOperation {

	public static void main(String[] args) 
	{ 
		Queue q = new Queue(4); 

		q.display(); 

		q.enqueue(12); 
		q.enqueue(43); 
		q.enqueue(78); 
		q.enqueue(56); 

		q.display(); 
		q.enqueue(69); 
		q.display(); 

		q.dequeue(); 
		q.dequeue(); 
		q.display(); 

		q.enqueue(10); 
		q.enqueue(20); 
		q.display(); 

	} 

}
