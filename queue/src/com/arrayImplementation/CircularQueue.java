package com.arrayImplementation;

public class CircularQueue {

	int[] arr;
	int topOfQueue;
	int size;
	int start;

	public CircularQueue(int size) {
		this.arr = new int[size];
		this.size = size;
		this.topOfQueue = -1;
		start = -1;
		System.out.println("Successfully created an empty queue of size : " + size);
	}

	public void enQueue(int value) {
		if (arr == null) {
			System.out.println("Queue is not yet created. Please create one first.");
		} else if (isQueueFull()) {
			System.out.println("Queue is full.");
		} else {
			if (start == -1) {
				start = 0;
			}
			if (topOfQueue + 1 == size) { // if top is already at last cell of array, then reset it to first cell
				topOfQueue = 0;
			} else {
				topOfQueue++;
			}
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue.");
		}
	}

	public void printQueue() {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		System.out.println("Queue Start : " + start);
		System.out.println("Queue End : " + topOfQueue);
	}

	public void deQueue() {
		if (isQueueEmpty()) {
			System.out.println("Queue is full.");
		} else {
			System.out.println("Dequeued : " + arr[start] + " from queue.");
			arr[start] = 0;
			// if there is only 1 element in Queue
			if (start == topOfQueue) {
				start = topOfQueue = -1;
			} else if (start + 1 == size) { // if start has reached end of array, then start again from 0
				start = 0;
			} else {
				start++;
			}
		}
	}

	public boolean isQueueEmpty() {
		if (topOfQueue == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isQueueFull() {
		if (topOfQueue + 1 == start) { // If we have completed a circle, then we can say that Queue is full
			return true;
		} else if ((start == 0) && (topOfQueue + 1 == size)) {
			return true;
		} else {
			return false;
		}
	}

	public void peekOperation() {
		// Return the value on top of Queue.
		if (!isQueueEmpty()) {
			System.out.println(arr[start]);
		} else {
			System.out.println("The queue is empty.");
		}
	}

	public void deleteQueue() {
		arr = null;
		System.out.println("Queue is successfully deleted.");
	}

}
