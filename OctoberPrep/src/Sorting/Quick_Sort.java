package Sorting;

public class Quick_Sort {

	public static void main(String[] args) {
		int[] arr= {12,3,23,45,11,7,89,37,65};
		quickSort(arr,0,arr.length-1);
		for(int val:arr) {
			System.out.print(val+" ");
		}
	}

	private static void quickSort(int[] arr, int lo, int hi) {

		if(lo>hi) {
			return;
		}
		
		int mid=(lo+hi)/2;
		int pivot=arr[mid];
		int left=lo;
		int right=hi;
		while(left<=right) {
			while(arr[left]<pivot) {
				left++;
			}
			while(arr[right]>pivot) {
				right--;
			}
			if(left<=right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);
		
	}

}
