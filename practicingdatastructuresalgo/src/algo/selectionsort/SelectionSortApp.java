package algo.selectionsort;

public class SelectionSortApp {
    public static void main(String[] args) {
        int[] inputArray = { 20, 47, 2, 1, 4, 30, 50, 31, 40 };

        int[] sortedArray = selectionSort(inputArray);

        printArray(sortedArray);
    }

    private static int[] selectionSort(int[] inputArray) {
        for(int i=0;i<inputArray.length;i++){
            int startIndex = i;
            int minIndex = i;
            for(int j=i;j<inputArray.length;j++){
                if (inputArray[j]<inputArray[minIndex]){
                    minIndex = j;
                }
            }
            swap(inputArray,startIndex,minIndex);
        }
        return inputArray;
    }

    private static void swap(int[] inputArray, int startIndex, int minIndex) {
        int temp = inputArray[minIndex];
        inputArray[minIndex] = inputArray[startIndex];
        inputArray[startIndex] = temp;
    }

    private static void printArray(int[] sortedArray) {
        System.out.print("[ ");
        for(int i=0;i<sortedArray.length;i++){
            System.out.print(sortedArray[i]);
            System.out.print(" ");
        }
        System.out.print("]");
    }
}
