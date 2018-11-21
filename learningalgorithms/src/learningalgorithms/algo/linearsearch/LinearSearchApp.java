package learningalgorithms.algo.linearsearch;

public class LinearSearchApp {

	public static void main(String[] args) {
		int[] inputArray = { 1, 2, 3, 2, 5 };
		int searchValue = 3;
		int index = -1;
		System.out.println("index: " + linearSearch(inputArray, searchValue, index));
		System.out.println("index: " + linearSearchRecursive(inputArray, searchValue, 0));
	}

	private static int linearSearch(int[] inputArray, int searchValue, int index) {
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] == searchValue) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static int linearSearchRecursive(int[] inputArray, int searchValue, int index) {
		if (index > inputArray.length - 1)
			return -1;
		if (inputArray[index] == searchValue)
			return index;
		else
			return linearSearchRecursive(inputArray, searchValue, index + 1);
	}

}
