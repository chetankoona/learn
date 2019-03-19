package gfg.algo.array;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3, -4, -1, 3, 2};
        execute(a);
        kadaneAlgo(a);
    }

    /**
     * This works very well
     */
    private static void kadaneAlgo(int[] a) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i = 0; i < a.length; i++) {
            maxEndingHere = maxEndingHere + a[i];
            if (maxEndingHere < 1) {
                maxEndingHere = 0;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        System.out.println("Maximum contiguous Array Sum (Kadane's Algo) = " + maxSoFar);
    }

    /**
     * This is raw logic, fails for some testcases...
     */
    private static void execute(int[] a) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i = 0; i < a.length; i++) {
            if (maxEndingHere < 1) {
                if (a[i] > 0) {
                    maxSoFar = a[i];
                    maxEndingHere = a[i];
                } else {
                    maxSoFar = 0;
                    maxEndingHere = 0;
                }
            } else {
                if (a[i] >= 0) {
                    maxSoFar = maxEndingHere + a[i];
                    maxEndingHere = maxEndingHere + a[i];
                } else {
                    maxEndingHere = maxEndingHere + a[i];
                }
            }
        }
        int finalMax;
        if (maxSoFar > maxEndingHere) finalMax = maxSoFar;
        else finalMax = maxEndingHere;
        System.out.println("Maximum contiguous Array Sum = " + finalMax);
    }
}
