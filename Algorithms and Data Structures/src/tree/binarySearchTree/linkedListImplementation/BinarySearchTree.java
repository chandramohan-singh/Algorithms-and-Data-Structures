package tree.binarySearchTree.linkedListImplementation;

import java.util.LinkedList;
import java.util.Queue;

import tree.node.Node;

public class BinarySearchTree {

	Node root;

	public Node getRoot() {
		return root;
	}

	// Constructor
	BinarySearchTree() {
		root = null;
	}

	// Insert new node in BST
	public void insertNode(int value) {
		root = insert(root, value);
	}

	// Insert
	private Node insert(Node currentNode, int value) {
		if (currentNode == null) {
			System.out.println("Successfully inserted " + value + " in binary search tree.");
			return createNewNode(value);
		} else if (value <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(), value));
			return currentNode;
		} else {
			currentNode.setRight(insert(currentNode.getRight(), value));
			return currentNode;
		}
	}

	// Create new node
	private Node createNewNode(int value) {
		Node node = new Node();
		node.setValue(value);
		return node;
	}

	// Pre-Order traversal of binary tree
	public void PreOrderTraversal(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");
		PreOrderTraversal(node.getLeft());
		PreOrderTraversal(node.getRight());
	}

	// In - order traversal of binary search tree
	public void InOrderTraversal(Node node) {
		if (node == null) {
			return;
		}
		PreOrderTraversal(node.getLeft());
		System.out.print(node.getValue() + " ");
		PreOrderTraversal(node.getRight());
	}

	// Post-Order traversal of binary tree
	public void PostOrderTraversal(Node node) {
		if (node == null) {
			return;
		}
		PreOrderTraversal(node.getLeft());
		PreOrderTraversal(node.getRight());
		System.out.print(node.getValue() + " ");
	}

	// Level order traversal of binary search tree
	public void levelOrderTraversal() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		if (root == null) {
			System.out.println("Tree does not exists.");
			return;
		}
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}

	// Search a node in binary search tree
	public void searchForValue(int value) {
		searchForValue(root, value);
	}

	// Search a node in binary search tree
	Node searchForValue(Node node, int value) {
		if (node == null) {
			System.out.println("Value " + value + " not found in binary search tree.");
			return null;
		} else if (node.getValue() == value) {
			System.out.println("Value " + value + " found in binary search tree.");
			return node;
		} else if (value < node.getValue()) {
			return searchForValue(node.getLeft(), value);
		} else {
			return searchForValue(node.getRight(), value);
		}
	}

	// Print Tree
	public void printTreeGraphically() {
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Integer> level = new LinkedList<Integer>();

		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);

		System.out.println("\n\nPrinting Tree Graphically");
		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}

		while (!queue.isEmpty()) {
			if (CurrentLevel == level.peek()) {
				if (queue.peek() == null) {
					queue.add(null);
					level.add(CurrentLevel + 1);
				} else {
					System.out.print(queue.peek().getValue() + "  ");
					queue.add(queue.peek().getLeft());
					level.add(CurrentLevel + 1);
					queue.add(queue.peek().getRight());
					level.add(CurrentLevel + 1);
					previousLevelWasAllNull = false;
				}
				queue.remove();
				level.remove();
			} else {
				// Change the Level
				System.out.println("\n");
				CurrentLevel++;
				if (previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}
	}

	// Deleting a node from BST
	public void deleteNode(int value) {
		delete(root, value);
	}

	private Node delete(Node root, int value) {
		if (root == null) {
			System.out.println("Value not found in binary search tree.");
			return null;
		}
		if (value < root.getValue()) {
			root.setLeft(delete(root.getLeft(), value));
		} else if (value > root.getValue()) {
			root.setRight(delete(root.getRight(), value));
		} else {
			// if nodeToBeDeleted have both children
			if (root.getLeft() != null && root.getRight() != null) {
				Node temp = root;
				Node minNodeForRight = minimumElement(temp.getRight());
				root.setValue(minNodeForRight.getValue());
				root.setRight(delete(root.getRight(), minNodeForRight.getValue()));
				// if nodeToBeDeleted has only left child
			} else if (root.getLeft() != null && root.getRight() == null) {
				root = root.getLeft();
				// if nodeToBeDeleted has only right child
			} else if (root.getRight() != null && root.getLeft() == null) {
				root = root.getRight();
			} else { // if nodeToBeDeleted do not have child - Leaf node
				root = null;
			}
		}
		return root;
	}

	// Get minimum element in binary search tree
	private Node minimumElement(Node root) {
		if (root.getLeft() == null)
			return root;
		else {
			return minimumElement(root.getLeft());
		}
	}

	// Delete entire binary search tree
	public void deleteTree() {
		root = null;
		System.out.println("Binary search tree deleted successfully.");
	}
}