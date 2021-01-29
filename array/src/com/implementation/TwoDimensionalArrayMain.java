package com.implementation;

/**
 * 
 * @author Chandra Mohan
 *
 */
public class TwoDimensionalArrayMain {

	public static void main(String[] args) {

		System.out.println("Creating a blank array of size 10X10...");
		TwoDimensionalArray sda = new TwoDimensionalArray(10, 10);
		sda.traverseArray();

		sda.insertValueInTheArray(0, 2, 20000);
		sda.traverseArray();

		sda.insertValueInTheArray(1, 2, 20001);
		sda.traverseArray();

		sda.accessSingleCell(0, 2);
		sda.accessSingleCell(6, 2);
		sda.accessSingleCell(2, 2);

		sda.searchSingleValue(10);
		sda.searchSingleValue(0);
		sda.searchSingleValue(20000);

		sda.deleteValuefromArray(0, 2);
		sda.traverseArray();

		sda.deleteArray();
		sda.traverseArray();

	}
}
