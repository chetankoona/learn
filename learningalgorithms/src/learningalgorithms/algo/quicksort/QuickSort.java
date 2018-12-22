package learningalgorithms.algo.quicksort;

public class QuickSort {


    public void sort(int[] inputArray) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    private void sort(int[] inputArray, int start, int end) {
        if (start < end) {
            //partitioning
            int pivot = partition(inputArray, start, end);

            //rec call for left half
            sort(inputArray, start, pivot - 1);
            //rec call for right half
            sort(inputArray, pivot + 1, end);
        }
    }

    private int partition(int[] inputArray, int start, int end) {
        int i = start - 1;
        int j = start;
        while (j <= end) {
            if (inputArray[j] <= inputArray[end]) {
                i = i + 1;
                swap(inputArray, i, j);
                j = j + 1;
            } else {
                j = j + 1;
            }
        }
        return i;
    }

    private void swap(int[] inputArray, int indexOne, int indexTwo) {
        int temp = inputArray[indexOne];
        inputArray[indexOne] = inputArray[indexTwo];
        inputArray[indexTwo] = temp;
    }
}
