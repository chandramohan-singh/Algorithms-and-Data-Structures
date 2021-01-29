package linkedList.singleLinkedList;

public class SingleLinkedListMain {

	public static void main(String[] args) {
		
		SingleLinkedList list = new SingleLinkedList();
		System.out.println("Creating the single linked list with value 5");
		list.createSingleLinkedList(5);
		list.printLinkedList();
		
		System.out.println("Inserting the value 10 at location 1 in linked list.");
		list.insertInLinkedListAtGivenLocation(10, 1);
		System.out.println("Inserting the value 20 at location 2 in linked list.");
		list.insertInLinkedListAtGivenLocation(20, 2);
		list.printLinkedList();
		System.out.println("Inserting the value 100 at the starting of the linked list.");
		list.insertAtStartInLinkedList(100);
		list.traverseLinkedList();
		System.out.println("Inserting the value 30 at location 2 in linked list.");
		list.insertInLinkedListAtGivenLocation(30, 2);
		System.out.println("Inserting the value 60 at location 4 in linked list.");
		list.insertInLinkedListAtGivenLocation(60, 4);
		System.out.println("Inserting the value 80 at the end of the linked list.");
		list.insertAtLastInLinkedList(80);
		list.traverseLinkedList();
	
		list.printLinkedList();
		System.out.println();
			
		
		System.out.println("Searching the node having value 30");
		list.searchNode(30);

		System.out.println("Searching the node having value 50");
		list.searchNode(50);
		
		System.out.println("\nDeleting the node from the start of linked list.");
		System.out.println("Before Deletion");
		list.printLinkedList();
		list.deleteFirstNode();
		System.out.println("After Deletion");
		list.printLinkedList();
		
		System.out.println("\nDeleting the node with location 0");
		System.out.println("Before Deletion");
		list.printLinkedList();
		list.deletionOfNode(0);
		System.out.println("After Deletion");
		list.printLinkedList();
		
		System.out.println("\nDeleting the node having location 3");
		System.out.println("Before deletion");
		list.printLinkedList();
		list.deletionOfNode(3);
		System.out.println("After deletiond");
		list.printLinkedList();
		
	
		System.out.println("\nDeleting the node having location = 100");
		System.out.println("Before Deletion:");
		list.printLinkedList();
		list.deletionOfNode(100);
		System.out.println("After Deletion:");
		list.printLinkedList();
		System.out.println();
		
		System.out.println("\nDeleting the node from the last of linked list.");
		System.out.println("Before Deletion");
		list.printLinkedList();
		list.deleteLastNode();
		System.out.println("After Deletion");
		list.printLinkedList();
		
		System.out.println("\nDeleting Linked List.");
		list.deleteLinkedList();
		System.out.println("\nTrying to print Linked List.");
		list.printLinkedList();
		
	
	}

}
