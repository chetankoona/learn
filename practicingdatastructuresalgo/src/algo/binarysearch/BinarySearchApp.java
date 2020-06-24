package algo.binarysearch;

public class BinarySearchApp {
    public static void main(String[] args) {
        int[] inArray = { 2, 30, 40, 50, 78, 80, 85, 90, 95, 100, 101 };
        int searchElement = 100;
        System.out.println(binarySearch(inArray, searchElement));
        System.out.println(binarySearchRecursion(inArray, searchElement, 0, inArray.length - 1));
    }

    private static int binarySearchRecursion(int[] inArray, int searchElement, int p, int r) {
        if(p<=r){
            int q = (p+r)/2;
            if (searchElement<inArray[q]) return binarySearchRecursion(inArray,searchElement,p,q-1);
            else if (searchElement>inArray[q]) return binarySearchRecursion(inArray,searchElement,q+1,r);
            else return q;
        }else {
            return -1;
        }
    }

    private static int binarySearch(int[] inArray, int searchElement) {
        int p=0;
        int r=inArray.length-1;
        while (p<=r){
            int q = (p+r)/2;
            if (searchElement < inArray[q]){
                r = q-1;
            }else if (searchElement > inArray[q]){
                p = q+1;
            }else return q;
        }
        return -1;
    }
}
