package Searching;

public class Binary_Search {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		boolean ans = binarySearch(arr, 54);
		if (ans)
			System.out.println("Yes, Item is Present in This Array");
		else
			System.out.println("No, Item Is Not Present in This Array");
	}

	private static boolean binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;
		int mid = (lo + hi) / 2;

		while (lo < arr.length) {
			if (arr[mid] > item) {
				hi = mid - 1;
			} else if (arr[mid] < item) {
				lo = mid + 1;
			} else {
				return true;
			}
			mid = (lo + hi) / 2;
		}

		return false;
	}

}
