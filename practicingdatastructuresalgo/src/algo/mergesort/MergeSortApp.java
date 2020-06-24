package algo.mergesort;

public class MergeSortApp {
    public static void main(String[] args) {
        int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};
        sort(inputArray);
        printArray(inputArray);
    }

    private static void sort(int[] inputArray) {
        sort(inputArray,0,inputArray.length-1);
    }

    private static void sort(int[] inputArray, int start, int end) {
        if (start<end){
            int mid = (start+end)/2;
            sort(inputArray, start, mid);
            sort(inputArray, mid+1, end);
            merge(inputArray,start,mid,end);
        }
    }

    private static void merge(int[] inputArray, int start, int mid, int end) {
        int[] tempArray = new int[end-start+1];
        int tempIndex = 0;
        int leftSlotIndex = start;
        int rightSlotIndex = mid+1;
        while (leftSlotIndex<=mid && rightSlotIndex<=end){
            if (inputArray[leftSlotIndex]<=inputArray[rightSlotIndex]){
                tempArray[tempIndex++] = inputArray[leftSlotIndex++];
            }else{
                tempArray[tempIndex++] = inputArray[rightSlotIndex++];
            }
        }
        while (leftSlotIndex<=mid){
            tempArray[tempIndex++] = inputArray[leftSlotIndex++];
        }
        while (rightSlotIndex<=end){
            tempArray[tempIndex++] = inputArray[rightSlotIndex++];
        }
        tempIndex=0;
        for (int i=start;i<=end;i++){
            inputArray[i] = tempArray[tempIndex++];
        }
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
