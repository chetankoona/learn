package gfg.ds.array;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubSequence {
    public static void main(String[] args) {
        int[] input = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(naiveMethod(input));
        System.out.println(hashMethod(input));
    }

    private static int hashMethod(int[] input) {
        HashSet<Integer> hashValues = new HashSet<Integer>();
        for (int i=0;i<input.length;i++){
            hashValues.add(input[i]);
        }
        int maxCount=0;
        int dynamicCount=0;
        for (int i=0;i<input.length;i++){
            if (!hashValues.contains(input[i]-1)){
                int currentValue = input[i];
                while (hashValues.contains(currentValue)){
                    dynamicCount++;
                    currentValue++;
                }
                if (dynamicCount>maxCount){
                    maxCount = dynamicCount;
                }
                dynamicCount=0;
            }
        }
        return maxCount;
    }

    private static int naiveMethod(int[] input) {
        Arrays.sort(input);
        int dynamicCount=0;
        int maxCount=0;
        for (int i=0;i<input.length;i++){
            if (i==0){
                dynamicCount++;
            }else if (input[i]==input[i-1]+1){
                dynamicCount++;
            }else {
                if (dynamicCount>maxCount){
                    maxCount = dynamicCount;
                }
                dynamicCount=0;
            }
        }
        return maxCount;
    }
}
