package stack.linkedListImplementation;

import linkedList.singleLinkedList.SingleLinkedList;

public class Stack {

	SingleLinkedList list;

	// constructor
	public Stack() {
		list = new SingleLinkedList();
	}

	public void push(int value) {
		if (list.getHead() == null) {
			list.createSingleLinkedList(value);
		} else {
			list.insertAtStartInLinkedList(value);
		}
		System.out.println("Inserted " + value + " in Stack !");
	}

	public int pop() {
		int value = -1;
		if (isEmpty()) {
			System.out.println("Stack underflow error.");
		} else {
			value = list.getHead().getValue();
			list.deleteFirstNode();
		}
		return value;
	}

	public boolean isEmpty() {
		if (list.getHead() == null) {
			return true;
		} else {
			return false;
		}
	}

	public int peek() {
		if (!isEmpty()) {
			return list.getHead().getValue();
		} else {
			System.out.println("The stack is empty!!");
			return -1;
		}
	}

	public void deleteStack() {
		list.setHead(null);
	}

}
