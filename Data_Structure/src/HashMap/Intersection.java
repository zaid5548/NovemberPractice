package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection {

	public static void main(String[] args) {
		int[] arr1= {10,1,2,5,6,7,10};
		int[] arr2= {1,7,15,20,10,10,3};
		ArrayList<Integer> ans=intersection(arr1,arr2);
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i)+" ");
		}
	}

	private static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
				
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<arr1.length;i++) {
			if(map.containsKey(arr1[i])) {
				int of=map.get(arr1[i]);
				map.put(arr1[i], of+1);
			}else {
				map.put(arr1[i], 1);
			}
		}
		
		ArrayList<Integer> ll=new ArrayList<>();
		for(int i=0;i<arr2.length;i++) {
			if(map.containsKey(arr2[i]) && map.get(arr2[i])>0) {
				ll.add(arr2[i]);
				int of=map.get(arr2[i]);
				map.put(arr2[i], of-1);
			}
		}
		
		return ll;
	}

}
