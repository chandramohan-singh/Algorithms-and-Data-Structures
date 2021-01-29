package com.implementation;

/**
 * 
 * @author Chandra Mohan
 *
 */
public class TwoDimensionalArray {
	int arr[][] = null;

	// Constructor
	public TwoDimensionalArray(int numberOfRows, int numberOfColumns) {
		this.arr = new int[numberOfRows][numberOfColumns];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				arr[row][col] = 0;
			}
		}
	}

	// Traverse the array
	public void traverseArray() {
		try {
			System.out.println("Printing the array...");
			for (int row = 0; row < arr.length; row++) {
				for (int col = 0; col < arr[0].length; col++) {
					System.out.print(arr[row][col] + "   ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Array does not exists");
		}

	}

	// Inserting value in the Array on index
	public void insertValueInTheArray(int row, int col, int value) {
		try {
			arr[row][col] = value;
			System.out.println("Successfully inserted " + value + " in the array.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index to access array !");
		}
	}

	// Accessing single value from given array
	public void accessSingleCell(int row, int col) {
		System.out.println("Accessing Row " + row + ", Column " + col + "...");
		try {
			System.out.println("Cell value is: " + arr[row][col]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index to access array !");
		}
		System.out.println();
	}

	// Searching a value from the Array
	public void searchSingleValue(int value) {
		System.out.println("Searching value " + value + " in the array");
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] == value) {
					System.out.println("Value is founud at location Row " + row + " & Column " + col + "\n");
					return;
				}
			}
		}
		System.out.println("Value is not found in Array");

	}

	// Deleting a value from Array
	public void deleteValuefromArray(int deleteValueFromThisRow, int deleteValueFromThisCol) {
		System.out.println(
				"Deleting value from Row " + deleteValueFromThisRow + " & Column " + deleteValueFromThisCol + "...");
		try {
			System.out.println("Successfully deleted: " + arr[deleteValueFromThisRow][deleteValueFromThisCol]);
			arr[deleteValueFromThisRow][deleteValueFromThisCol] = 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
			System.out.println("Cant delete the value as cell# provided is not in the range of array...");
		}
	}

	// Delete the Array
	public void deleteArray() {
		arr = null;
		System.out.println("Array has been succefully deleted");
	}
}
