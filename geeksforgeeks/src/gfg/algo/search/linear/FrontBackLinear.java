package gfg.algo.search.linear;

public class FrontBackLinear {

	// Java program to implement front and back
	// search
	public static void main(String args[]) {
		int[] input = { 100, 45, 65, 3, 49, 29, 57, 15, 39, 59, 70, 80, 20 };
		int x = 57;
		System.out.println(search(input, x) ? "Yes" : "No");
	}

	private static boolean search(int[] input, int x) {
		int front = 0;
		int back = input.length - 1;
		while (front <= back) {
			if (input[front] == x || input[back] == x) {
				return true;
			}
			front = front + 1;
			back = back - 1;
		}
		return false;
	}

}
