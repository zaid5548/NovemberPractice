package Sorting;

public class Merge_Sort {

	public static void main(String[] args) {
		
		int[] arr={2,13,45,21,67,43,3,11,90,134,456,44};
		int[] ans=mergeSort(arr,0,arr.length-1);
		for(int val:ans) {
			System.out.print(val+" ");
		}
	}

	private static int[] mergeSort(int[] arr,int lo,int hi) {
		if(lo==hi) {
			int[] br=new int[1];
			br[0]=arr[lo];
			return br;
		}
		
		int mid=(lo+hi)/2;
		
		int[] fh=mergeSort(arr, lo, mid);
		int[] sh=mergeSort(arr, mid+1, hi);
		
		int res[]=mergeToSort(fh, sh);
		
		return res;
		
	}

	private static int[] mergeToSort(int[] one, int[] two) {
		int left=0;
		int right=0;
		int[] array=new int[one.length+two.length];
		int cnt=0;
		while(left<one.length && right<two.length) {
			if(one[left]<two[right]) {
				array[cnt]=one[left];
				cnt++;
				left++;
			}else if(one[left]>two[right]) {
				array[cnt]=two[right];
				right++;
				cnt++;
			}else {
				array[cnt]=one[left];
				cnt++;
				left++;
				right++;
			}
		}
		
		while(left<one.length) {
			array[cnt]=one[left];
			left++;
			cnt++;
		}
		while(right<two.length) {
			array[cnt]=two[right];
			right++;
			cnt++;
		}
		return array;
	}

}
