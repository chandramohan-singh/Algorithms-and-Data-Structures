package com.Implementation;

public class BinaryHeapMain {

	public static void main(String[] args) {
		System.out.println("Creating a blank Heap");
		BinaryHeap heap = new BinaryHeap(10);
		
		heap.insertInBinaryHeap(100);
		heap.insertInBinaryHeap(90);
		heap.insertInBinaryHeap(80);
		heap.insertInBinaryHeap(70);
		heap.insertInBinaryHeap(60);
		heap.insertInBinaryHeap(50);
		heap.insertInBinaryHeap(40);
		heap.insertInBinaryHeap(30);
		heap.insertInBinaryHeap(20);
		
		heap.printBinaryHeap();
		heap.extractHeadOfBinaryHeap();
		heap.printBinaryHeap();
		heap.insertInBinaryHeap(110);
		heap.extractHeadOfBinaryHeap();
		heap.printBinaryHeap();
	}
}
