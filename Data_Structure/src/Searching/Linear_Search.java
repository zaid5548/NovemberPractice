package Searching;

public class Linear_Search {

	public static void main(String[] args) {
		int[] arr= {10,20,30,50,70,90}; 
		System.out.println(LinearSearch(arr,70));

	}

	private static int LinearSearch(int[] arr, int item) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==item) {
				return i;
			}
		}
		
		return -1;
	}

}
