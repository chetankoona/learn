package algo.quicksort;

public class QuickSortApp {
    public static void main(String[] args) {
        int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};
        sort(inputArray);
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

    private static void sort(int[] inputArray) {
        sort(inputArray,0,inputArray.length-1);
    }

    private static void sort(int[] inputArray, int start, int end) {
        if (start<end){
            int partition = partition(inputArray, start,end);
            sort(inputArray,start,partition-1);
            sort(inputArray,partition+1,end);
        }
    }

    private static int partition(int[] inputArray, int start, int end) {
        int i=start-1;
        int j=start;
        while (j<=end){
            if (inputArray[j]<=inputArray[end]) swap(inputArray,++i,j++);
            else j++;
        }
        return i;
    }

    private static void swap(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i]=inputArray[j];
        inputArray[j]=temp;
    }
}
