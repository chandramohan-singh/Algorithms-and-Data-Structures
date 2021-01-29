package com.implementation.doubleLinkedList;

public class DoubleCircularLinkedListMain {

	public static void main(String[] args) {
		DoubleCircularLinkedList list = new DoubleCircularLinkedList();
		list.createDoubleLinkedList(5);
		list.insertInLinkedList(10, 1);
		list.insertInLinkedList(20, 2);
		list.insertInLinkedList(30, 3);
		list.insertInLinkedList(40, 1);

		System.out.println("Printing List.");
		list.traverseLinkedList();
		list.printLinkedList();

		System.out.println("Printing List in reverse Order.");
		list.printLinkedListInReverseOrder();
		list.traverseLinkedListInReverseOrder();

		System.out.println("\nSearching the node having value 40.");
		list.searchNode(40);

		System.out.println("\nSearching the node having value 200: ");
		list.searchNode(200);

		System.out.println("\nDeleting first node of linked list.");
		System.out.println("Before Deletion.");
		list.traverseLinkedList();
		list.deleteFirstNode();
		;
		System.out.println("After Deletion.");
		list.printLinkedList();

		System.out.println("\nDeleting last node of linked list.");
		System.out.println("Before Deletion.");
		list.traverseLinkedList();
		list.deleteLastNode();
		System.out.println("After Deletion.");
		list.printLinkedList();

		System.out.println("\nIs Linked list is circular : " + list.isCircularLinkdedList());

		System.out.println("\nDeleting the node having location = 0: ");
		System.out.println("Before Deletion.");
		list.traverseLinkedList();
		list.deletionOfNode(0);
		System.out.println("After Deletion.");
		list.printLinkedList();

		System.out.println("\nDeleting the node having location = 3: ");
		System.out.println("Before Deletion.");
		list.traverseLinkedList();
		list.deletionOfNode(3);
		System.out.println("After Deletion.");
		list.printLinkedList();

		System.out.println("\nDeleting the node having location = 20: ");
		System.out.println("Before Deletion.");
		list.traverseLinkedList();
		list.deletionOfNode(20);
		System.out.println("After Deletion.");
		list.traverseLinkedList();

		list.deleteLinkedList();
		list.traverseLinkedList();

	}

}
