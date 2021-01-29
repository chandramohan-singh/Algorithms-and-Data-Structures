package com.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
	AVLNode root;

	public AVLNode getRoot() {
		return root;
	}

	AVLTree() {
		root = null;
	}

	// Insert values in AVL Tree
	void insert(int value) {
		root = insert(root, value);
	}

	// Helper Method
	private AVLNode insert(AVLNode currentNode, int value) {
		if (currentNode == null) {
			System.out.println("Successfully inserted " + value + " in AVL Tree");
			return createNewNode(value);
		} else if (value <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(), value));
		} else {
			currentNode.setRight(insert(currentNode.getRight(), value));
		}

		int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());

		if (balance > 1) {
			// LL Condition
			if (checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
				currentNode = rightRotate(currentNode);
				// LR Condition
			} else {
				currentNode.setLeft(leftRotate(currentNode.getLeft()));
				currentNode = rightRotate(currentNode);
			}
		} else if (balance < -1) {
			// RR Condition
			if (checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
				currentNode = leftRotate(currentNode);
				// RL Condition
			} else {
				currentNode.setRight(rightRotate(currentNode.getRight()));
				currentNode = leftRotate(currentNode);
			}
		}
		if (currentNode.getLeft() != null) {
			currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
		}
		if (currentNode.getRight() != null) {
			currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
		}
		currentNode.setHeight(calculateHeight(currentNode));
		return currentNode;

	}

	// Helper Method
	private AVLNode leftRotate(AVLNode currentNode) {
		AVLNode newRoot = currentNode.getRight();
		currentNode.setRight(currentNode.getRight().getLeft());
		newRoot.setLeft(currentNode);
		currentNode.setHeight(calculateHeight(currentNode));
		newRoot.setHeight(calculateHeight(newRoot));
		return newRoot;
	}

	// Helper Method
	private AVLNode rightRotate(AVLNode currentNode) {
		AVLNode newRoot = currentNode.getLeft();
		currentNode.setLeft(currentNode.getLeft().getRight());
		newRoot.setRight(currentNode);
		currentNode.setHeight(calculateHeight(currentNode));
		newRoot.setHeight(calculateHeight(newRoot));
		return newRoot;
	}

	// Check Tree is balance or not
	private int checkBalance(AVLNode rootLeft, AVLNode rootRight) {
		/*
		 * if current node is a leaf node then no need to check balance of its children
		 * if left node node is not there then simply return right node's height + 1 we
		 * need to make it -1 because blank height is considered having height as '-1'
		 */
		if ((rootLeft == null) && (rootRight == null)) {
			return 0;
		} else if (rootLeft == null) {
			return -1 * (rootRight.getHeight() + 1);
		} else if (rootRight == null) {
			return rootLeft.getHeight() + 1;
		} else {
			// +1 is not required, as both right and left child exits and 1 gets nullified
			return rootLeft.getHeight() - rootRight.getHeight();
		}
	}

	// Calculate height of the Node
	private int calculateHeight(AVLNode currentNode) {
		if (currentNode == null) {
			return 0;
		}
		return 1 + Math.max((currentNode.getLeft() != null ? currentNode.getLeft().getHeight() : -1),
				(currentNode.getRight() != null ? currentNode.getRight().getHeight() : -1));

	}

	// creates a new blank new node
	private AVLNode createNewNode(int value) {
		AVLNode node = new AVLNode();
		node.setValue(value);
		node.setHeight(0);// Since this is a leaf node, its height is 0
		return node;
	}

	// Level order traversal of AVL
	public void levelOrderTraversal() {
		if (root == null) {
			System.out.println("Tree does not exists.");
			return;
		}
		Queue<AVLNode> queue = new LinkedList<AVLNode>();
		queue.add(root);
		System.out.println("Printing Level order traversal of AVL Tree.");
		while (!queue.isEmpty()) {
			AVLNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}

	// Deleting a node from AVL
	public void deleteNodeOfAVLTree(int value) {
		System.out.println("Deleting " + value + " from AVL Tree.");
		root = delete(root, value);
	}

	// Helper Method for delete
	public AVLNode delete(AVLNode currentNode, int value) {
		if (currentNode == null)
			return null;
		if (value < currentNode.getValue()) {
			currentNode.setLeft(delete(currentNode.getLeft(), value));
		} else if (value > currentNode.getValue()) {
			currentNode.setRight(delete(currentNode.getRight(), value));
		} else { // If currentNode is the node to be deleted
			// if nodeToBeDeleted have both children
			// Find minimum element from right subtree
			// Replace current node with minimum node from right subtree
			// Delete minimum node from right now
			if (currentNode.getLeft() != null && currentNode.getRight() != null) {
				AVLNode temp = currentNode;
				AVLNode minNodeForRight = minimumElement(temp.getRight());
				currentNode.setValue(minNodeForRight.getValue()); 
				delete(currentNode.getRight(), minNodeForRight.getValue());
				// if nodeToBeDeleted has only left child
			} else if (currentNode.getLeft() != null) {
				currentNode = currentNode.getLeft();
				// if nodeToBeDeleted has only right child
			} else if (currentNode.getRight() != null) {
				currentNode = currentNode.getRight();
			} else { // if nodeToBeDeleted do not have child
				currentNode = null;
			}
			// if it is a leaf node,then no need to do balancing for this node, do only for its ancestors
			return currentNode;
		}

		int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());
		if (balance > 1) {
			// LL Condition
			if (checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
				currentNode = rightRotate(currentNode);
				// LR Condition
			} else {
				currentNode.setLeft(leftRotate(currentNode.getLeft()));
				currentNode = rightRotate(currentNode);
			}
		} else if (balance < -1) {
			// RR Condition
			if (checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
				currentNode = leftRotate(currentNode);
				// RL Condition
			} else {
				currentNode.setRight(rightRotate(currentNode.getRight()));
				currentNode = leftRotate(currentNode);
			}
		}
		if (currentNode.getLeft() != null) {
			currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
		}
		if (currentNode.getRight() != null) {
			currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
		}
		currentNode.setHeight(calculateHeight(currentNode));
		return currentNode;
	}

	// Get minimum element in binary search tree
	public static AVLNode minimumElement(AVLNode root) {
		if (root.getLeft() == null)
			return root;
		else {
			return minimumElement(root.getLeft());
		}
	}

	public void printTreeGraphically() {
		Queue<AVLNode> queue = new LinkedList<AVLNode>();
		Queue<Integer> level = new LinkedList<Integer>();

		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);

		System.out.println("\nPrinting Level order traversal of Tree.");
		if (root == null) {
			System.out.println("Tree does not exists.");
			return;
		}
		while (!queue.isEmpty()) {
			if (CurrentLevel == level.peek()) { // if we are in the same level
				if (queue.peek() == null) {
					queue.add(null);
					level.add(CurrentLevel + 1);
				} else {
					queue.add(queue.peek().getLeft());
					level.add(CurrentLevel + 1);
					queue.add(queue.peek().getRight());
					level.add(CurrentLevel + 1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");
				level.remove();
			} else { // level has changed
				System.out.println("\n");
				CurrentLevel++;
				if (previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}
	}
}
