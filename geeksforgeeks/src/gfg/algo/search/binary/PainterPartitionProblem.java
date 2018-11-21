package gfg.algo.search.binary;

import java.util.Arrays;
import java.util.Scanner;

public class PainterPartitionProblem {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			print(k,n,arr);
		}
	}

	private static void print(int k, int n, int[] arr) {
		System.out.println("");
		System.out.println(k+" "+n);
		System.out.println(Arrays.toString(arr));
	}

}
