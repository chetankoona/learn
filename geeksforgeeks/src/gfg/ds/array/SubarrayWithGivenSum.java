package gfg.ds.array;

public class SubarrayWithGivenSum {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 7, 5 };
		int sum = 12;
		printSubArray(input, sum);
	}

	private static void printSubArray(int[] input, int sum) {
		int fromIndex = 0;
		int toIndex = 0;
		int dynamicSum = 0;

		for (int i = 0; i < input.length; i++) {
			dynamicSum = dynamicSum + input[i];
			toIndex = i;
			if (dynamicSum > sum) {
				dynamicSum = dynamicSum - input[fromIndex];
				fromIndex = fromIndex + 1;
			}
			if (dynamicSum == sum) {
				break;
			}
		}
		if (dynamicSum == sum) {
			fromIndex++;
			toIndex++;
			System.out.println("Sum of elements from " + fromIndex + " to " + toIndex + " is " + sum);
		} else
			System.out.println("There is no such continous subarray which equals " + sum);
	}

}
