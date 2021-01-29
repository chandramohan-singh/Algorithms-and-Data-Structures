package com.arrayImplementation;

public class BinarySearchTree {

	int[] arr;
	int lastUsedIndex;

	// Constructor
	public BinarySearchTree(int size) {
		arr = new int[size];
		lastUsedIndex = 1;
		System.out.println("Blank Binary Serach Tree of size " + size + " has been created.");
	}

	// Check if array is full
	boolean isBinarySearchTreeFull() {
		if (arr[arr.length - 1] != 0) {
			return true;
		} else {
			return false;
		}
	}

	// Insert new Node
	public void insertNode(int value) {
		if (!isBinarySearchTreeFull()) {
			int index = 1;
			arr = insert(value, index);
			System.out.println("Successfully inserted " + value + " in the tree.");
		} else {
			System.out.println("Could not insert value in the Tree as it is full.");
		}
	}

	private int[] insert(int value, int index) {
		if (arr[index] == 0) {
			arr[index] = value;
			if (index > lastUsedIndex)
				lastUsedIndex = index;
			return arr;
		} else {
			if (arr[index] > value) {
				index = index * 2;
				arr = insert(value, index);
			} else if (arr[index] < value) {
				index = index * 2 + 1;
				arr = insert(value, index);
			}
		}
		return arr;
	}

	// Pre-Order traversal of binary tree
	public void preOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		if (arr[index] != 0) {
			System.out.print(arr[index] + " ");
		}
		preOrder(index * 2);
		preOrder(index * 2 + 1);
	}

	// In-Order Traversal of binary tree
	public void inOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		inOrder(index * 2);
		if (arr[index] != 0) {
			System.out.print(arr[index] + " ");
		}
		inOrder(index * 2 + 1);
	}

	// Post-Order Traversal of binary tree
	public void postOrder(int index) {
		if (index > lastUsedIndex) {
			return;
		}
		postOrder(index * 2);
		postOrder(index * 2 + 1);
		if (arr[index] != 0) {
			System.out.print(arr[index] + " ");
		}
	}

	// Level-Order traversal of binary tree
	public void levelOrder() {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (arr[i] != 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	// Do a linear search on the array
	public int search(int value) {
		for (int i = 0; i <= lastUsedIndex; i++) {
			if (arr[i] == value) {
				System.out.println(value + " exists in the Tree on location : " + i);
				return i;
			}
		}
		System.out.println(value + " does not exists in Tree.");
		return -1;
	}

	// Delete operation of binary search tree
	public void delete(int value) {
		int location = search(value);
		// If Value does not exists in Array
		if (location == -1) {
			return;
		} else {
			if (location == arr.length - 1) {
				arr[location] = 0;
			} else {
				deleteHelper(location);
			}

			System.out.println("Successfully deleted " + value + " from the Tree.");
		}
	}

	private void deleteHelper(int location) {
		if (arr.length - 1 >= (location * 2) && arr[location * 2] != 0 && arr.length - 1 >= (location * 2 + 1)
				&& arr[location * 2 + 1] != 0) {
			int temp = location;
			location = minimumElement(location * 2 + 1);
			arr[temp] = arr[location];
			deleteHelper(location);
		} else if (arr.length - 1 >= (location * 2) && arr[location * 2] != 0) {
			arr[location] = arr[location * 2];
			arr[location * 2] = 0;
		} else if (arr.length - 1 > (location * 2 + 1) && arr[location * 2 + 1] != 0) {
			arr[location] = arr[location * 2 + 1];
			arr[location * 2 + 1] = 0;
		} else {
			arr[location] = 0;
		}
	}

	// Get minimum element in binary search tree
	private int minimumElement(int index) {
		if (arr[index] == 0) {
			return index / 2;
		} else {
			index = index * 2;
			return minimumElement(index);
		}
	}

	// Delete binary search Tree
	public void deleteBinarySearchTree() {
		try {
			arr = null;
			System.out.println("Tree has been deleted successfully.");
		} catch (Exception e) {
			System.out.println("There was an error deleting the tree.");
		}
	}

}
