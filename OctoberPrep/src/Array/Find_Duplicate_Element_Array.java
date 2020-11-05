package Array;

import java.util.HashMap;
import java.util.Set;

public class Find_Duplicate_Element_Array {

	public static void main(String[] args) {
		int[] arr= {1,2,3,3,3,3,3,4,4};
		System.out.println(findDuplicate(arr));

	}

	private static int findDuplicate(int[] arr) {
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			
			if(map.containsKey(arr[i])) {
				int of=map.get(arr[i]);
				map.put(arr[i], of+1);
			}else {
				map.put(arr[i], 1);
			}	
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i])>max) {
				max=arr[i];
			}
		}
		return max;
	}

}
