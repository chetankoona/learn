package adt;

import java.util.Arrays;

public class SampleClass {

	public static void main(String[] args) {
		int[] inputArray = { 20, 47, 2, 1};
		inputArray[1]=50;
		printArray(inputArray);
	}

	private static void printArray(int[] inputArray) {
		System.out.print("[ ");
		for (int i=0;i<inputArray.length;i++){
			System.out.print(inputArray[i]);
			System.out.print(" ");
		}
		System.out.print(" ]");
	}

}
