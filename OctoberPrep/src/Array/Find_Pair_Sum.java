package Array;

import java.util.HashMap;
import java.util.Scanner;

public class Find_Pair_Sum {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		int sum=scn.nextInt();
		//input
		/*6
		8 7 2 5 3 1
		10*/
//		findPair(arr,sum);
		findPairHashMap(arr, sum);
	}

	
	//Naive Approach T.C.-- O(n^2)
	private static void findPair(int[] arr, int sum) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==sum) {
					System.out.println(arr[i]+" + "+arr[j]+" = "+sum);
				}
			}
		}
	}
	
	
	//T.C.-- O(n) Using HashMap
	private static void findPairHashMap(int[] arr, int sum) {
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			
			if(map.containsKey(sum-arr[i])) {
				System.out.println("pair found at index "+map.get(sum-arr[i])+" and "+i);
				return;
			}
			
			map.put(arr[i], i);
			
		}
		System.out.println("Pair Not Found");
	}

}
