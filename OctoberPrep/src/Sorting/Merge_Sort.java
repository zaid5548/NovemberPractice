package Sorting;

public class Merge_Sort {

	public static void main(String[] args) {
		int[] arr= {12,3,23,45,11,7,89,37,65};
		int[] ans=mergeSort(arr,0,arr.length-1);
		for(int val:ans) {
			System.out.print(val+" ");
		}

	}

	private static int[] mergeSort(int[] arr, int lo, int hi) {
		
		if(lo==hi) {
			int[] br=new int[1];
			br[0]=arr[lo];
			return br;
		}
		
		int mid=(lo+hi)/2;
		int[] fh=mergeSort(arr, lo, mid);
		int[] sh=mergeSort(arr, mid+1, hi);
		
		int[] res=mergeToSorted(fh,sh);
		
		return res;
		
		
	}

	private static int[] mergeToSorted(int[] one, int[] two) {
		int left=0;
		int right=0;
		int[] ans=new int[one.length+two.length];
		int cnt=0;
		
		while(left<one.length && right<two.length) {
			if(one[left]<two[right]) {
				ans[cnt++]=one[left++];
			}else if(one[left]>two[right]) {
				ans[cnt++]=two[right++];
			}else {
				ans[cnt++]=one[left++];
				right++;
			}
		}
		
		while(left<one.length) {
			ans[cnt++]=one[left++];
		}
		while(right<two.length) {
			ans[cnt++]=one[right++];
		}
		
		return ans;
	}

}
