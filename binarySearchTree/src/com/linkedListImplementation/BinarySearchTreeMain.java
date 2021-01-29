package com.linkedListImplementation;

public class BinarySearchTreeMain {

	public static void main(String[] args) {

		// Constructor
		BinarySearchTree binarySearchTree = new BinarySearchTree();

		// Inserting values in BST
		System.out.println("Inserting 10 nodes in Tree");
		binarySearchTree.insertNode(100);
		binarySearchTree.insertNode(40);
		binarySearchTree.insertNode(120);
		binarySearchTree.insertNode(110);
		binarySearchTree.insertNode(50);
		binarySearchTree.insertNode(30);
		binarySearchTree.insertNode(150);
		binarySearchTree.insertNode(105);
		binarySearchTree.insertNode(130);

		// Traversing BST in Pre order
		System.out.println("\nPrinting BST in Pre-Order.");
		binarySearchTree.PreOrderTraversal(binarySearchTree.root);

		// Traversing BST in IN order
		System.out.println("\n\nPrinting BST in In-Order.");
		binarySearchTree.InOrderTraversal(binarySearchTree.root);
		
		// Traversing BST in Post order
		System.out.println("\n\nPrinting BST in Post-Order.");
		binarySearchTree.PostOrderTraversal(binarySearchTree.root);
		
		// Traversing BST in Level order
		System.out.println("\n\nPrinting BST in Level-Order.");
		binarySearchTree.levelOrderTraversal();

		binarySearchTree.printTreeGraphically();

		// Searching non-existing value in Tree
		binarySearchTree.searchForValue(80);

		// Searching existing value in Tree
		binarySearchTree.searchForValue(60);

		// Deleting Node from Tree
		binarySearchTree.deleteNode(80);
		binarySearchTree.printTreeGraphically();

		binarySearchTree.deleteNode(57);
		binarySearchTree.printTreeGraphically();

		binarySearchTree.deleteNode(60);
		binarySearchTree.printTreeGraphically();

		binarySearchTree.deleteNode(50);
		binarySearchTree.printTreeGraphically();

		// Deleting entire Tree
		binarySearchTree.deleteTree();

	}

}