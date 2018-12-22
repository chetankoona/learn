package learningalgorithms.algo.mergesort;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] inputArray = {20, 47, 2, 1, 4, 30, 50, 31, 40};
        MergeSort sorter = new MergeSort();
        sorter.sort(inputArray);
        System.out.println("Sorted array using mergesort = " + Arrays.toString(inputArray));
    }

}
