package com.linkedListmplemenation;

/**
 * @author Chandra Mohan Singh
 *
 */
public class BinaryTreeMain {

	public static void main(String[] args) {

		// Create a blank Tree
		BinaryTree binaryTree = new BinaryTree();

		// Insert 15 nodes in the binaryTree
		System.out.println("Inserting 10 nodes to binaryTree");
		for (int i = 1; i <= 15; i++)
			binaryTree.insert(i * 15);

		System.out.println("Level-order of binaryTree:");
		binaryTree.levelOrder();
		System.out.println();

		System.out.println("Pre-order of binaryTree:");
		binaryTree.preOrder(binaryTree.root);
		System.out.println();

		System.out.println("Post-order of binaryTree:");
		binaryTree.postOrder(binaryTree.root);
		System.out.println();

		System.out.println("In-order of binaryTree:");
		binaryTree.inOrder(binaryTree.root);
		System.out.println();

		System.out.println("Searching node 150 in the binaryTree.");
		binaryTree.search(150);

		System.out.println("Deleting node having value 80 in the binaryTree.");
		binaryTree.deleteNodeOfBinaryTree(80);

		System.out.println("Deleting node having value 120 in the binaryTree.");
		binaryTree.deleteNodeOfBinaryTree(120);
		binaryTree.levelOrder();

		System.out.println("Deleting the entire Tree.");
		binaryTree.deleteTree();

	}

}
