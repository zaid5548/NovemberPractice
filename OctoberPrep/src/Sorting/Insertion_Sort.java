package Sorting;

public class Insertion_Sort {

	public static void main(String[] args) {
		int[] arr= {12,3,23,45,11,7,89,37,65};
		InsertionSort(arr);
		for(int val:arr) {
			System.out.print(val+" ");
		}

	}
	
	public static void InsertionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int temp=arr[i];
			int j=i-1;
			while(j>=0) {
				
				if(arr[j]>temp) {
					arr[j+1]=arr[j];
				}else {
					break;
				}
				
				j--;
			}
			arr[j+1]=temp;
		}
	}
	
}
