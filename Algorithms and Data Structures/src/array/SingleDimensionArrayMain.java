package array;

/**
 * 
 * @author Chandra Mohan
 *
 */
public class SingleDimensionArrayMain {

	public static void main(String[] args) {

		System.out.println("Creating a blank array of size 15!!");
		SingleDimensionArray singleDimensionArray = new SingleDimensionArray(15);

		System.out.println("Printing the Array!!");
		singleDimensionArray.traverseArray();
		System.out.println();

		System.out.println("Inserting values in the array!!");
		singleDimensionArray.insertValueOnGivenIndex(0, 0);
		singleDimensionArray.insertValueOnGivenIndex(1, 10);
		singleDimensionArray.insertValueOnGivenIndex(2, 20);
		singleDimensionArray.insertValueOnGivenIndex(3, 30);
		singleDimensionArray.insertValueOnGivenIndex(4, 40);
		singleDimensionArray.insertValueOnGivenIndex(5, 50);
		singleDimensionArray.insertValueOnGivenIndex(6, 60);
		singleDimensionArray.insertValueOnGivenIndex(7, 70);
		singleDimensionArray.insertValueOnGivenIndex(8, 80);
		singleDimensionArray.insertValueOnGivenIndex(9, 90);
		singleDimensionArray.insertValueOnGivenIndex(10, 100);
		singleDimensionArray.insertValueOnGivenIndex(15, 150);
		System.out.println();

		System.out.println("Printing the Array!!");
		singleDimensionArray.traverseArray();
		System.out.println();

		System.out.println("Accessing 1st index in the array...");
		singleDimensionArray.accessingIndex(1);
		System.out.println();

		System.out.println("Accessing 9th index in the array...");
		singleDimensionArray.accessingIndex(9);
		System.out.println();

		System.out.println("Accessing 15th index in the array...");
		singleDimensionArray.accessingIndex(15);
		System.out.println();

		System.out.println("Searching value 90 in the array...");
		singleDimensionArray.searchValueInAnArray(90);
		System.out.println();

		System.out.println("Searching value 200 in the array...");
		singleDimensionArray.searchValueInAnArray(200);
		System.out.println();

		System.out.println("Deleting value from the 5th index...");
		System.out.println("Before Deleting: ");
		singleDimensionArray.traverseArray();
		singleDimensionArray.deleteValueFromArray(5);
		System.out.println("After Deleting: ");
		singleDimensionArray.traverseArray();
		System.out.println();

		System.out.println("Deleting value from 15th index of array...");
		System.out.println("Before Deleting: ");
		singleDimensionArray.traverseArray();
		singleDimensionArray.deleteValueFromArray(15);
		System.out.println("After Deleting: ");
		singleDimensionArray.traverseArray();
		System.out.println();

		singleDimensionArray.deleteArray();
		System.out.println("After Deleting: ");
		singleDimensionArray.traverseArray();

	}
}
