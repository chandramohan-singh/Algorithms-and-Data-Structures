package com.implementation;

/**
 * 
 * @author Chandra Mohan
 *
 */
public class SingleDimensionArray {

	int arr[] = null;

	// Constructor
	public SingleDimensionArray(int sizeOfArray) {
		arr = new int[sizeOfArray];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	// Traverse the array
	public void traverseArray() {
		try {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		} catch (Exception e) {
			System.out.println("Array no longer exists!!");
		}
	}

	// Inserting value in the Array on the index
	public void insertValueOnGivenIndex(int index, int valueToBeInserted) {
		try {
			if (arr[index] == 0) {
				arr[index] = valueToBeInserted;
				System.out.println("Successfully inserted " + valueToBeInserted + " at index: " + index);
			} else {
				System.out.println("This index is already occupied by another value.");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index to access array!!");
		}
	}

	// Accessing single value from given array
	public void accessingIndex(int index) {
		try {
			System.out.println(arr[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index to access array!!");
		}
	}

	// Searching a value from the Array
	public void searchValueInAnArray(int valueToSearch) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == valueToSearch) {
				System.out.println("Value found!!");
				System.out.println("Index of " + valueToSearch + " is: " + i);
				return;
			}
		}
		System.out.println(valueToSearch + " is not found!!");
	}

	// Deleting a value from Array
	public void deleteValueFromArray(int index) {
		try {
			arr[index] = 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
			System.out.println("Cant delete the value as index provided is not in the range of array!!");
		}
	}

	// Delete the Array
	public void deleteArray() {
		arr = null;
		System.out.println("Array has been deleted succefully!!");
	}
}
