package Sorting;

public class Selection_Sort {

	public static void main(String[] args) {

		int[] arr = { 2, 13, 45, 21, 67, 403, 3, 11, 90, 134, 456, 44 };
		selectionSort(arr);
	}

	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

}
