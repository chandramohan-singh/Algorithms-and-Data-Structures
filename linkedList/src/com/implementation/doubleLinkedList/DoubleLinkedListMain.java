package com.implementation.doubleLinkedList;

public class DoubleLinkedListMain {

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		list.createDoubleLinkedList(5);

		System.out.println("Inserting 10 in the Linked List as location : 1");
		list.insertInLinkedList(10, 1);
		
		System.out.println("Inserting 20 in the Linked List as location : 2");
		list.insertInLinkedList(20, 2);

		System.out.println("Inserting 30 in the Linked List as location : 3");
		list.insertInLinkedList(30, 3);
		
		System.out.println("Inserting 40 in the Linked List as location : 4");
		list.insertInLinkedList(40, 4);
		
		System.out.println("\nPrinting Linked List.");
		list.traverseLinkedList();

				
		System.out.println("\nSearching the node having value 40: ");
		list.searchNode(40);
		
		System.out.println("\nSearching the node having value 400: ");
		list.searchNode(400);
		
		
		System.out.println("\nLinked List in order");
		list.traverseLinkedList();
		System.out.println("Linked List in reverse order");
		list.traverseLinkedListInReverseOrder();
		
		
		System.out.println("\n\nDeleting the node having location = 2: ");
		System.out.println("List before deletion: ");
		list.traverseLinkedList();
		list.deletionOfNode(2);
		System.out.println("List after deletion: ");
		list.traverseLinkedList();
			
		
		System.out.println("\n\nDeleting the node having location = 3: ");
		System.out.println("List before deletion: ");
		list.traverseLinkedList();
		list.deletionOfNode(3);
		System.out.println("List after deletion: ");
		list.traverseLinkedList();
		
		
		list.deleteLinkedList();
		list.traverseLinkedList();
		
				
	}

}
