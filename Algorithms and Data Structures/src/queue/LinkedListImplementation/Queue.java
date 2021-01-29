package queue.LinkedListImplementation;

import linkedList.singleLinkedList.Node;
import linkedList.singleLinkedList.SingleLinkedList;

public class Queue {
	SingleLinkedList list;

	public Queue() {
		list = new SingleLinkedList();
	}

	public void enQueue(int value) {
		if (list.getHead() == null) {
			list.createSingleLinkedList(value);
			System.out.println("Successfully inserted " + value + " in the queue");
		} else {
			// push a value on last of queue, update list tail too
			list.insertAtLastInLinkedList(value);
			System.out.println("Successfully inserted " + value + " in the queue");
		}
	}

	public void printQueue() {
		if (!isQueueEmpty()) {
			Node tempNode = list.getHead();
			while (tempNode.getNext() != null) {
				System.out.println(tempNode.getValue());
				tempNode = tempNode.getNext();
			}
		} else {
			System.out.println("Queue is empty.");
		}
	}
	
	public int deQueue() {
		int value = -1;
		if (isQueueEmpty()) {
			System.out.println("Queue is empty.");
		} else {
			value = list.getHead().getValue();
			list.deleteFirstNode();
		}
		return value;
	}

	public int peek() {
		if (!isQueueEmpty()) {
			return list.getHead().getValue();
		} else {
			System.out.println("The queue is empty.");
			return -1;
		}
	}

	public boolean isQueueEmpty() {
		if (list.getHead() == null) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteQueue() {
		list.setHead(null);
		System.out.println("Queue deleted successfully.");
	}

}
