package Sorting;

public class Bubble_Sort {

	public static void main(String[] args) {
		int[] arr= {2,13,45,21,67,43,3,11,90,134,456,44};
		bubbleSort(arr);
	}

	private static void bubbleSort(int[] arr) {
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=1;j<(arr.length-i);j++) {
				if(arr[j-1]>arr[j]) {
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for(int val:arr) {
			System.out.print(val+" ");
		}
		
	}

}
