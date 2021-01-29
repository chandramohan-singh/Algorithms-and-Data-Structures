package stack.arrayImplementation;

public class Stack {

	int[] arr;
	/*
	 * topOfStack variable to keep the track of the last occupied index in
	 * Array,this will help in insertion/deletion
	 */
	int topOfStack;

	public Stack(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("Successfully created an empty Stack of Size: " + size);
	}

	public void push(int value) {
		// Show stack overflow error, if array is full
		if (isFullStack()) {
			System.out.println("Stack overflow error.");
		} else {
			topOfStack++;
			arr[topOfStack] = value;
			System.out.println("Successfully inserted " + value + " in the stack");
		}
	}

	public void pop() {
		// Show stack overflow error, if array is empty
		if (isEmptyStack()) {
			System.out.println("Stack underflow error.");
		} else {
			System.out.println("Poping value from Stack : " + arr[topOfStack] + ".");
			arr[topOfStack] = 0; // inserting the default value
			topOfStack--;
		}
	}

	public void peek() {
		if (!isEmptyStack())
			System.out.println("Top of Stack: " + arr[topOfStack]);
		else {
			System.out.println("The stack is empty.");
		}
	}

	public void deleteStack() {
		arr = null;
		System.out.println("Stack is successfully deleted.");
	}

	public boolean isEmptyStack() {
		// if top pointer is zero, the stack is empty
		if (topOfStack == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFullStack() {
		if (topOfStack == arr.length - 1) {
			System.out.println("Stack is full.");
			return true;
		} else {
			return false;
		}
	}

}
