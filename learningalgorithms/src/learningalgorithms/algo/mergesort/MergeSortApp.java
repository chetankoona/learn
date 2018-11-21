package learningalgorithms.algo.mergesort;

import java.util.Arrays;

public class MergeSortApp {

	public static void main(String[] args) {
		int[] inputArray = { 47, 20, 2, 1};

		mergeSort(inputArray, 0, inputArray.length - 1);

		printArray(inputArray);
	}

	private static void mergeSort(int[] inputArray, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(inputArray, p, q);
			mergeSort(inputArray, q + 1, p);
			merge(inputArray, p, q, r);
		}
	}

	private static void merge(int[] inputArray, int p, int q, int r) {
		int[] first_half = Arrays.copyOfRange(inputArray, p, q+1);
		int[] second_half = Arrays.copyOfRange(inputArray, q + 1, r+1);
		int i = 0, j = 0;
		while (i < first_half.length && j < second_half.length) {
			if (first_half[i] < second_half[j]) {
				inputArray[p] = first_half[i];
				i++;
			} else {
				inputArray[p] = second_half[j];
				j++;
			}
			p++;
		}
	}

	private static void printArray(int[] inputArray) {
		for (int j = 0; j < inputArray.length; j++)
			System.out.println(inputArray[j]);
	}
}
