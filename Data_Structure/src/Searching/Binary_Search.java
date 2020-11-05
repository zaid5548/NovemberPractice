package Searching;

public class Binary_Search {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50 };
		System.out.println(BinarySearch1(arr, 220));
	}

	private static int BinarySearch1(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;
		int mid = (lo + hi) / 2;

		while (lo < arr.length) {
			if (arr[mid] > item) {
				hi = mid - 1;
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				return mid;
			}
			mid = (lo + hi) / 2;
		}

		return -1;
	}

}
