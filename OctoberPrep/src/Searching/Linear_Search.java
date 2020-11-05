package Searching;

public class Linear_Search {

	public static void main(String[] args) {
		
		int[] arr= { 12, 14, 32, 16, 54, 89, 76, 123, 122, 456, 873, 1, 3, 2 };
		boolean ans=linearSearch(arr,76);
		if(ans)
			System.out.println("Yes, Item is Present in This Array");
		else
			System.out.println("No, Item Is Not Present in This Array");
	}

	private static boolean linearSearch(int[] arr,int item) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==item) {
				return true;
			}
		}
		return false;
	}

}
