package tree.binarySearchTree.arrayImplementation;

public class BinarySearchTreeMain {

	public static void main(String[] args) {

		// Constructor
		BinarySearchTree binarySearchTree = new BinarySearchTree(25);

		// Inserting values in BST
		binarySearchTree.insertNode(100);
		binarySearchTree.insertNode(40);
		binarySearchTree.insertNode(120);
		binarySearchTree.insertNode(110);
		binarySearchTree.insertNode(50);
		binarySearchTree.insertNode(30);
		binarySearchTree.insertNode(150);
		binarySearchTree.insertNode(105);
		binarySearchTree.insertNode(130);
		binarySearchTree.insertNode(160);

		// Pre order Traverse
		System.out.println("\n\nPre-order Traversal:");
		binarySearchTree.preOrder(1);

		// In order Traverse
		System.out.println("\n\nIn-order Traversal:");
		binarySearchTree.inOrder(1);

		// Post order Traverse
		System.out.println("\n\nPost-order Traversal:");
		binarySearchTree.postOrder(1);

		// Traversing BST in Level order
		System.out.println("\n\nPrinting BST in Level-Order.");
		binarySearchTree.levelOrder();

		// Searching existing value in Tree
		System.out.println("\n\nSearching 120 in the BST.");
		binarySearchTree.search(120);

		// Searching non existing value in Tree
		System.out.println("\n\nSearching 70 in the BST.");
		binarySearchTree.search(70);

		// Deleting Node from Tree
		System.out.println("\n\nDeleting 30 in the BST.");
		binarySearchTree.delete(30);
		System.out.println("\n\nDeleting 90 in the BST.");
		binarySearchTree.delete(90);
		System.out.println("\n\nDeleting 160 in the BST.");
		binarySearchTree.delete(160);

	}

}
