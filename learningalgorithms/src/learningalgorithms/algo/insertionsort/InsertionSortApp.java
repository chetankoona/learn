package learningalgorithms.algo.insertionsort;

public class InsertionSortApp {

	public static void main(String[] args) {
		int[] inputArray = { 20, 47, 2, 1, 4, 30, 50, 31, 40 };
		int[] sortedArray = insertionSort(inputArray);
		printArray(sortedArray);
	}

	private static int[] insertionSort(int[] inputArray) {
		for (int i = 1; i < inputArray.length; i++) {
			for (int j = i; j > 0; j--) {
				if (inputArray[j] < inputArray[j - 1]) {
					swap(inputArray, j, j - 1);
				}
			}
		}
		return inputArray;
	}

	private static void swap(int[] inputArray, int indexOne, int indexTwo) {
		int temp = inputArray[indexOne];
		inputArray[indexOne] = inputArray[indexTwo];
		inputArray[indexTwo] = temp;
	}

	private static void printArray(int[] inputArray) {
		for (int j = 0; j < inputArray.length; j++)
			System.out.println(inputArray[j]);
	}

}
