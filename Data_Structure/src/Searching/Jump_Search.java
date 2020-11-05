package Searching;

import java.util.Scanner;

public class Jump_Search {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
//		int[] arr = new int[n];
		int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
//		for (int i = 0; i < n; i++) {
//			arr[i] = scn.nextInt();
//		}
//		0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610
		System.out.println(jumpSearch(arr, 34));
	}
	private static int jumpSearch(int[] arr, int item) {
		int n = arr.length;
		int step = (int) Math.floor(Math.sqrt(arr.length));
		int i = step - 1;
		while (i < arr.length && item > arr[i]) {
			i += step;
		}
		for (int j = (i - step) + 1; j <= i && j < arr.length; j++) {
			if (arr[j] == item) {
				return j;
			}
		}
		return -1;
	}
}
