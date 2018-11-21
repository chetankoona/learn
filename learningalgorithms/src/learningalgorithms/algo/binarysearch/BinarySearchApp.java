package learningalgorithms.algo.binarysearch;

public class BinarySearchApp {

	public static void main(String[] args) {
		int[] inArray = { 2, 30, 40, 50, 78, 80, 85, 90, 95, 100, 101 };
		int searchElement = 100;
		System.out.println(binarySearch(inArray, searchElement));
		System.out.println(binarySearchRecursion(inArray, searchElement, 0, inArray.length - 1));
	}

	//This method returns index
	private static int binarySearchRecursion(int[] a, int x, int p, int r) {
		if (p <= r) {
			int q = (p + r) / 2;
			if (x < a[q])
				return binarySearchRecursion(a, x, p, q - 1);
			else if (x > a[q])
				return binarySearchRecursion(a, x, q + 1, r);
			else
				return q;
		} else
			return -1;
	}

	public static int binarySearch(int[] a, int x) {
		int p = 0;
		int r = a.length - 1;

		while (p <= r) {
			int q = (p + r) / 2;
			if (x < a[q]) {
				r = q - 1;
			} else if (x > a[q]) {
				p = q + 1;
			} else {
				return q;
			}
		}
		return -1;
	}
}
