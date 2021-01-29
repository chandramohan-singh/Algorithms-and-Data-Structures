package com.linkedListImplementation;

public class QueueMain {

	public static void main(String[] args) {

		System.out.println("Creating a queue.");
		Queue queue = new Queue();

		System.out.println("\nEnqueueing values into queue.");
		for (int i = 1; i <= 10; i++) {
			queue.enQueue(i * 5);
		}

		System.out.println("\nPrinting value from queue.");
		queue.printQueue();
		
		System.out.println("\nPeeking value from queue.");
		System.out.println(queue.peek());

		System.out.println("\nDequeueing values into queue");
		for (int i = 0; i < 10; i++) {
			System.out.println(queue.deQueue());
		}
		
		System.out.println("\nDeleting the Queue.");
		queue.deleteQueue();
	}
}
