package stack.arrayImplementation;

public class StackMain {

	public static void main(String[] args) {

		System.out.println("Creating a stack of size 10.");
		Stack stack = new Stack(10);

		System.out.println("\nPushing values in the Stack.");
		for (int i = 1; i <= 10; i++) {
			stack.push(i * 5);
		}

		System.out.println("\nPeeking value from stack");
		stack.peek();

		System.out.println("\nPoping values from the Stack.");
		for (int i = 1; i <= 10; i++) {
			stack.pop();
		}
		
		System.out.println("\nPeeking value from stack after pop");
		stack.peek();

		System.out.println("\nDeleting the Stack.");
		stack.deleteStack();

	}
}
