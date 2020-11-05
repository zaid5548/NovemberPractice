package HashMap;

import java.util.HashMap;

public class LongestSubSequence {

	public static void main(String[] args) {
//		int[] arr= {5,10,3,12,11,2,7,1,4};
		int[] arr= {5,10,3,12,11,2,79,4};
		subsequence(arr);
	}

	public static void subsequence(int[] arr) {
		
		HashMap<Integer, Boolean> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i]-1)) {
				map.put(arr[i], false);
				
			}else {
				map.put(arr[i], true);
			}
			
			
			if(map.containsKey(arr[i]+1)) {
				map.put(arr[i]+1, false);
				
			}
		}
		
		int maxL=0;
		int start=Integer.MIN_VALUE;
		
		for(int key:map.keySet()) {
			
			if(map.get(key)) {
				int cnt=1;
				while(map.containsKey(key+cnt)) {
					cnt++;
				}
				
				if(cnt>maxL) {
					maxL=cnt;
					start=key;
				}
					
			}
			
		}
		
		for(int i=start;i<start+maxL;i++) {
			System.out.print(i+" ");
		}
		
	}
	
}
