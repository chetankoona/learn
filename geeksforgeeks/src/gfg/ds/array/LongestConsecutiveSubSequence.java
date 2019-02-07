package gfg.ds.array;

import java.util.Arrays;
import java.util.Scanner;

public class LongestConsecutiveSubSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCnt = sc.nextInt();
        for (int i = 0; i < testCaseCnt; i++) {
            int count = sc.nextInt();
            int[] inputArray = new int[count];
            for (int j = 0; j < count; j++) {
                inputArray[j] = sc.nextInt();
            }
            Arrays.sort(inputArray);

            int highConsecutiveCount = 1;
            int liveConsecutiveCount = 1;
            for (int k = 0; k < count-1; k++) {
                if (inputArray[k] + 1 == inputArray[k + 1]) {
                    liveConsecutiveCount++;
                } else {
                    if (liveConsecutiveCount > highConsecutiveCount) highConsecutiveCount = liveConsecutiveCount;
                    liveConsecutiveCount = 1;
                }
            }
            if(liveConsecutiveCount>highConsecutiveCount) highConsecutiveCount=liveConsecutiveCount;
            System.out.println(highConsecutiveCount);
        }
    }
}
