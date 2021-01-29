package queue.arrayImplementation;

public class CircularQueueMain {

	public static void main(String[] args) {

		System.out.println("Creating an empty queue.");
		CircularQueue queue = new CircularQueue(10);

		System.out.println("\nEnqueuing 10 values in the queue.");
		for (int i = 1; i <= 10; i++) {
			queue.enQueue(i * 5);
		}
		
		System.out.println("\nPrinting value from queue.");
		queue.printQueue();
		

		System.out.println("\nPeeking value from queue.");
		queue.peekOperation();
		
		System.out.println("\nDeQueuing value from queue.");
		queue.deQueue();

		System.out.println("\nPrinting value from queue.");
		queue.printQueue();
		
		System.out.println("\nEnqueuing 150 values in the queue.");
		queue.enQueue(150);
		
		System.out.println("\nPrinting value from queue.");
		queue.printQueue();
		
		System.out.println("\nDeleting the Queue.");
		queue.deleteQueue();
	}
}