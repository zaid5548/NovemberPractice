package Sorting;

public class Insertion_Sort {

	public static void main(String[] args) {
		
		int[] arr={2,13,45,21,67,43,3,11,90,134,456,44};
		System.out.println("Sorted Array is");
		insertionSort(arr);
		for(int val:arr) {
			System.out.print(val+" ");
		}
	}

	private static void insertionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int temp=arr[i];
			int j=i-1;
			while(j>=0) {
				if(temp<arr[j]) {
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
