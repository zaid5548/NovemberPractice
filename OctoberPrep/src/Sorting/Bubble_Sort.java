package Sorting;

public class Bubble_Sort {

	public static void main(String[] args) {
		int[] arr= {12,3,23,45,11,7,89,37,65};
		bubbleSort(arr);
		for(int val:arr) {
			System.out.print(val+" ");
		}

	}
	
	public static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=1;j<(arr.length-i);j++) {
				if(arr[j-1]>arr[j]) {
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
}
