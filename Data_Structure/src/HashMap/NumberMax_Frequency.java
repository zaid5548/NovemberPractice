package HashMap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class NumberMax_Frequency {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		Integer n=scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scn.nextInt();
		}
		System.out.println(maxNumber(arr));

	}

	private static int maxNumber(int[] arr) {
		
		HashMap<Integer, Integer> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			int num=arr[i];
			if(map.containsKey(num)) {
				int of=map.get(num);
				map.put(num, of+1);
			}else {
				map.put(num, 1);
			}
			
		}
		
		int max=Integer.MIN_VALUE;
		int num=0;
		
		Set<Integer> keys=map.keySet();
		
		for(int key:keys) {
			if(map.get(key)>max) {
				max=map.get(key);
				num=key;
			}
		}
		return num;
	}

	
}
