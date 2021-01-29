package com.arrayImplementation;

public class QueueMain {

	public static void main(String[] args) {

		System.out.println("Creating an empty queue.");
		Queue queue = new Queue(10);

		System.out.println("\nEnqueuing 10 values in the queue.");
		for (int i = 1; i <= 10; i++) {
			queue.enQueue(i * 5);
		}
		
		System.out.println("\nPrinting value from queue.");
		queue.printQueue();

		System.out.println("\nPeek value from queue.");
		queue.peekOperation();
		
		System.out.println("\nDequeue values from queue.");
		for (int i = 0; i <= 10; i++) {
			queue.deQueue();
		}

		System.out.println("\nDeleting the entire Queue.");
		queue.deleteQueue();

	}

}