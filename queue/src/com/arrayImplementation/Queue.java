package com.arrayImplementation;

public class Queue {

	int[] arr;
	int topOfQueue;
	int beginningOfQueue;

	public Queue(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
		System.out.println("Successfully created an empty queue of size: " + size);
	}

	public void enQueue(int value) {
		if (isQueueFull()) {
			System.out.println("Queue is full.");
		} else if (isQueueEmpty()) { // If the queue is empty then we need to initialize beginning index
			beginningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue");
		} else { // if the queue already has some elements in it then no need to initialize beginning index
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted " + value + " in the queue");
		}
	}

	public void printQueue() {
		if (!isQueueEmpty()) {
			for (int i = beginningOfQueue; i <= topOfQueue; i++) {
				System.out.println(arr[i] + "   ");
			}
		} else {
			System.out.println("Queue is empty.");
		}
	}

	public void deQueue() {
		if (isQueueEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			System.out.println("Dequeued : " + arr[beginningOfQueue] + " from queue.");
			beginningOfQueue++;
			if (beginningOfQueue > topOfQueue) { // If last element in the Queue is Dequeued
				beginningOfQueue = topOfQueue = -1;
			}
		}
	}

	public boolean isQueueEmpty() {
		if ((beginningOfQueue == -1) || (beginningOfQueue == arr.length))
			return true;
		else
			return false;
	}

	public boolean isQueueFull() {
		if (topOfQueue == arr.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	public void peekOperation() {
		if (!isQueueEmpty()) {
			System.out.println(arr[beginningOfQueue]);
		} else {
			System.out.println("The queue is empty.");
		}
	}

	public void deleteQueue() {
		arr = null;
		System.out.println("Queue deleted successfully.");
	}
}
