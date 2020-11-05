package Sorting;

public class Selection_Sort {

	public static void main(String[] args) {
		int[] arr= {12,3,23,45,11,7,89,37,65};
		selectionSort(arr);
		for(int val:arr) {
			System.out.print(val+" ");
		}
	}

	private static void selectionSort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			int min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		
	}

}
