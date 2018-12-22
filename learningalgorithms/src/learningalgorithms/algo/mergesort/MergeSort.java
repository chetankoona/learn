package learningalgorithms.algo.mergesort;

public class MergeSort {

    public void sort(int[] inputArray) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    private void sort(int[] inputArray, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = (start + end) / 2;
        sort(inputArray, start, mid);
        sort(inputArray, mid + 1, end);
        merge(inputArray, start, mid, end);
    }

    private void merge(int[] inputArray, int start, int mid, int end) {
        int leftSlotIndex = start;
        int rightSlotIndex = mid + 1;
        int[] tempArray = new int[end - start + 1];
        int tempIndex = 0;
        while (leftSlotIndex <= mid && rightSlotIndex <= end) {
            if (inputArray[leftSlotIndex] < inputArray[rightSlotIndex]) {
                tempArray[tempIndex] = inputArray[leftSlotIndex];
                leftSlotIndex = leftSlotIndex + 1;
            } else {
                tempArray[tempIndex] = inputArray[rightSlotIndex];
                rightSlotIndex = rightSlotIndex + 1;
            }
            tempIndex = tempIndex + 1;
        }

        if (leftSlotIndex <= mid) {
            while (leftSlotIndex <= mid) {
                tempArray[tempIndex] = inputArray[leftSlotIndex];
                leftSlotIndex = leftSlotIndex + 1;
                tempIndex = tempIndex + 1;
            }
        } else if (rightSlotIndex <= end) {
            while (rightSlotIndex <= end) {
                tempArray[tempIndex] = inputArray[rightSlotIndex];
                rightSlotIndex = rightSlotIndex + 1;
                tempIndex = tempIndex + 1;
            }
        }

        for (int i = 0; i < tempArray.length; i++) {
            inputArray[start + i] = tempArray[i];
        }
    }
}
