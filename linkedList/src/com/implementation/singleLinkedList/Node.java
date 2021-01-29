package com.implementation.singleLinkedList;

/**
 * @author Chandra Mohan Singh
 *
 */
public class Node {

	private int value;
	private Node next;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return value + "";
	}

}
