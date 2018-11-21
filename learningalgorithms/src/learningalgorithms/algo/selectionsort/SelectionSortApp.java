package learningalgorithms.algo.selectionsort;

public class SelectionSortApp {

	public static void main(String[] args) {
		int[] inputArray = { 20, 47, 2, 1, 4, 30, 50, 31, 40 };

		int[] sortedArray = selectionSort(inputArray);

		printArray(sortedArray);
	}

	private static int[] selectionSort(int[] inputArray) {
		int startIndex = 0;
		while (startIndex < inputArray.length) {
			int minIndex = startIndex;
			for (int i = startIndex; i < inputArray.length; i++) {
				if (inputArray[minIndex] > inputArray[i])
					minIndex = i;
			}
			swap(inputArray, startIndex, minIndex);
			startIndex++;
		}
		return inputArray;
	}

	private static void swap(int[] inputArray, int startIndex, int minIndex) {
		int temp = inputArray[startIndex];
		inputArray[startIndex] = inputArray[minIndex];
		inputArray[minIndex] = temp;
	}

	private static void printArray(int[] inputArray) {
		for (int j = 0; j < inputArray.length; j++)
			System.out.println(inputArray[j]);
	}

}
