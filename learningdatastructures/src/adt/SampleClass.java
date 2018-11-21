package adt;

import java.util.Arrays;

public class SampleClass {

	public static void main(String[] args) {
		int[] inputArray = { 20, 47, 2, 1};
		
		int[] firstHalf = Arrays.copyOfRange(inputArray, 0, 4);
		
		for(int i=0; i<firstHalf.length; i++) {
			System.out.println(firstHalf[i]);
		}
	}

}
