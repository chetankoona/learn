package gfg.ds.array;

import java.util.Arrays;

public class RotateAlgo {

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        int rotateCount = 2;
        rotate(inputArray, rotateCount);
    }

    private static void rotate(int[] inputArray, int rotateCount) {
        System.out.println("Input Array "+Arrays.toString(inputArray));
        final int length = inputArray.length;
        int[] outputArray = new int[length];

        for (int i = 0; i < length; i++) {
            int index = i + rotateCount;
            if (index >= length) index = Math.abs(length - index);
            outputArray[i] = inputArray[index];
        }

        System.out.println("Output Array "+Arrays.toString(outputArray));
    }
}
