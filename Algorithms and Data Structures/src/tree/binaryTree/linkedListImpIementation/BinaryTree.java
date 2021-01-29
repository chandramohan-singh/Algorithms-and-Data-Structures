package tree.binaryTree.linkedListImpIementation;

import java.util.*;

import tree.node.Node;

/**
 * @author Chandra Mohan Singh
 *
 */
public class BinaryTree {
	Node root;

	// Constructor for creating a blank Binary Tree
	BinaryTree() {
		this.root = null;
	}

	// inserts a new node at deepest place in Tree
	public void insert(int value) {
		Node node = new Node();
		node.setValue(value);
		if (root == null) {
			root = node;
			System.out.println("Successfully inserted new node at Root.");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node.");
				break;
			} else if (presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node.");
				break;
			} else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
		}
	}

	// Pre-order traversal of binary tree
	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}

	// In-order traversal of binary tree
	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		inOrder(node.getRight());
	}

	// Post-order traversal of binary tree
	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}

	// Level order traversal of binary tree
	public void levelOrder() {
		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}

	// Search for a given value in binary tree
	public void search(int value) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			if (presentNode.getValue() == value) {
				System.out.println("Value : " + value + " is found in Tree.");
				return;
			} else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}
		System.out.println("Value " + value + " is not found in Tree.");
	}

	// Delete node from binary tree
	public void deleteNodeOfBinaryTree(int value) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			// if node is found then copy deepest node here and delete deepest node.
			if (presentNode.getValue() == value) {
				presentNode.setValue(getDeepestNode().getValue());
				DeleteDeepestNode();
				System.out.println("Deleted the node !!");
				return;
			} else {
				if (presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null) {
					queue.add(presentNode.getRight());
				}
			}
		}
		System.out.println("Did not find the node.");
	}

	// Delete deepest node
	public void DeleteDeepestNode() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				previousNode.setRight(null);
				return;
			} else if ((presentNode.getRight() == null)) {
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}
	}

	// Get last node of last level of binary tree
	public Node getDeepestNode() {
		// make an empty queue. Queue is Interface and LinkedList is class
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null) {
				queue.add(presentNode.getRight());
			}
		}
		return presentNode;
	}

	// Delete Tree
	public void deleteTree() {
		root = null;
		System.out.println("Binary Tree has been deleted successfully");
	}

}
