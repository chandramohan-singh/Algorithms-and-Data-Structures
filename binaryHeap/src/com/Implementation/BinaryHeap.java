package com.Implementation;

public class BinaryHeap {
	int[] arr;
	int sizeOfTree;

	/**
	 * Adding 1 here so that first cell of the array can be left blank all the time.
	 * This is to eliminate problem of array starting from index 0.
	 */
	public BinaryHeap(int size) {
		arr = new int[size + 1];
		this.sizeOfTree = 0;
		System.out.println("Empty Binary Heap has been created !");
	}

	public boolean isBinaryHeapEmpty() {
		if (sizeOfTree <= 0) {
			System.out.println("Binary Heap is empty.");
			return true;
		} else {
			System.out.println("Binary Heap is not empty.");
			return false;
		}
	}

	public void deleteBinaryHeap() {
		arr = null;
		System.out.println("Binary Heap has been deleted successfuly.");
	}

	// Insert a new value in Binary Heap
	public void insertInBinaryHeap(int value) {
		System.out.println("Inserting " + value + " in Binary Heap.");
		// Doing +1 because sizeOfTree always points to the last occupied cell of the array
		arr[sizeOfTree + 1] = value;
		sizeOfTree++;
		HeapifyBottomToTop(sizeOfTree);
		System.out.println("Inserted " + value + " successfully in Binary Heap.");
	}

	// Peek into Heap
	public void peek() {
		if (sizeOfTree == 0) {
			System.out.println("Binary Heap is empty.");
		} else {
			System.out.println("Head of the Binary Heap is : " + arr[1]);
		}
	}

	// Extract Head of Heap
	public int extractHeadOfBinaryHeap() {
		if (sizeOfTree == 0) {
			System.out.println("Heap is empty.");
			return -1;
		} else {
			System.out.println("Head of the Binary Heap is: " + arr[1]);
			System.out.println("Extracting the Head.");
			int extractedValue = arr[1];
			arr[1] = arr[sizeOfTree];
			sizeOfTree--;
			HeapifyTopToBottom(1);
			System.out.println("Successfully extracted value from Heap.");
			return extractedValue;
		}
	}

	public void HeapifyBottomToTop(int index) {
		int parent = index / 2;
		// We are at root of the tree. Hence no more Heapifying is required.
		if (index <= 1) {
			return;
		}
		// If Current value is smaller than its parent, then we need to swap
		if (arr[index] < arr[parent]) {
			int tmp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = tmp;
		}
		HeapifyBottomToTop(parent);
	}

	public void HeapifyTopToBottom(int index) {
		int left = index * 2;
		int right = (index * 2) + 1;
		int smallestChild = 0;

		// If there is no child of this node, then nothing to do. Just return.
		if (sizeOfTree < left) {
			return;
			// If there is only left child of this node, then do a comparison and return.
		} else if (sizeOfTree == left) {
			if (arr[index] > arr[left]) {
				int tmp = arr[index];
				arr[index] = arr[left];
				arr[left] = tmp;
			}
			return;
		} else { // If both children are there
			if (arr[left] < arr[right]) { // Find out the smallest child
				smallestChild = left;
			} else {
				smallestChild = right;
			}
			// If Parent is greater than smallest child, then swap
			if (arr[index] > arr[smallestChild]) {
				int tmp = arr[index];
				arr[index] = arr[smallestChild];
				arr[smallestChild] = tmp;
			}
		}
		HeapifyTopToBottom(smallestChild);
	}

	public void printBinaryHeap() {
		System.out.println("Printing all the elements of the Binary Tree.");
		// Printing from 1 because 0th cell is dummy
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	public int sizeOfArray() {
		return arr.length;
	}

	public int sizeOfTree() {
		System.out.println("Size Of Tree : " + sizeOfTree);
		return sizeOfTree;
	}

}
