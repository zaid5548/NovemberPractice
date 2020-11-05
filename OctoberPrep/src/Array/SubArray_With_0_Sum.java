package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SubArray_With_0_Sum {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		subarrayWith_0_Sum(arr);
		System.out.println();
		System.out.println("******************");
		subarrayWith_0_SumUsingHashMap(arr);
		//input
		/*10
		3 4 -7 3 1 3 1 -4 -2 -2
		*/
	}

	
	//T.C.-- O(n^2)
	private static void subarrayWith_0_Sum(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int sum=0;
			for(int j=i;j<arr.length;j++) {
				sum+=arr[j];
				if(sum==0) {
					System.out.print("SubArray["+i+","+j+"]  " );
				}
			}
		}
	}
	
	
	//Using HashMap T.C.-- O(n)
	private static void subarrayWith_0_SumUsingHashMap(int[] arr) {
		
		Map<Integer, List<Integer>> map=new HashMap<>();
		
		insert(map,0,-1);	
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(map.containsKey(sum)) {
				List<Integer> list=map.get(sum);
				for(Integer val:list) {
					System.out.print("SubArray["+(val+1)+ ","+i+"]  ");
				}
			}
			insert(map, sum, i);
		}
	}


	private static<K,V> void insert(Map<K, List<V>> map, K key, V value) {
		
		if(!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		map.get(key).add(value);
	}

}
