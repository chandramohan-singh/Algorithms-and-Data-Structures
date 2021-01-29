package com.implementation.singleLinkedList;

public class SingleCircularLinkedListMain {

	public static void main(String[] args) {
		SingleCircularLinkedList list = new SingleCircularLinkedList();
		list.createSingleLinkedList(5);
		list.insertInLinkedList(10, 1);
		list.insertInLinkedList(25, 2);
		list.insertInLinkedList(30, 3);
		list.insertInLinkedList(50, 4);
		
		System.out.println("Printing Linked List.");
		list.traverseLinkedList();
		
		System.out.println("Printing size of the Linked List " + list.getSize());
		
		System.out.println("\nIs Linked list is circular : " + list.isCircularLinkdedList());
	    
		System.out.println("Inserting 20 at the location 5.");
		list.insertInLinkedList(20, 5);
		list.printLinkedList();
		
		System.out.println("Inserting 1 at the location 0.");
		list.insertInLinkedList(1, 0);
		list.traverseLinkedList();
		
		System.out.println("Inserting 40 at the starting of the Linked List.");
		list.insertInStartingOfLInkedList(40);
		list.printLinkedList();
		
		System.out.println("Inserting 100 at the location 10.");
		list.insertInLinkedList(100, 10);
		list.printLinkedList();
		
		System.out.println("Inserting 200 at the last of the Linked List.");
		list.insertInLastOfLInkedList(200);
		list.printLinkedList();
		
		System.out.println("Searching the node having value 40.");
		list.searchNode(40);
		
		System.out.println("\n\nSearching the node having value 200.");
		list.searchNode(200);
		
		
		System.out.println("\n\nDeleting the node having location 2.");
		System.out.println("Before deletion.");
		list.traverseLinkedList();
		list.deletionOfNode(2);
		System.out.println("After deletion.");
		list.traverseLinkedList();
		
		
		System.out.println("\n\nDeleting the node having location 0.");
		System.out.println("Before deletion.");
		list.traverseLinkedList();
		list.deletionOfNode(0);
		System.out.println("After deletion.");
		list.traverseLinkedList();
		
		
		System.out.println("\n\nDeleting the node having location 15");
		System.out.println("Before deletion...");
		list.traverseLinkedList();
		list.deletionOfNode(15);
		System.out.println("After deletion...");
		list.traverseLinkedList();
		
		list.deleteLinkedList();
		list.traverseLinkedList();
		
	}

}
