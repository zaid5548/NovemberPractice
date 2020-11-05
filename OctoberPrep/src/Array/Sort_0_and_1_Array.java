package Array;

public class Sort_0_and_1_Array {

	public static void main(String[] args) {
		int[] arr= {1,0,1,0,1,0,0,1};
		sort(arr);
		for(int val:arr) {
			System.out.print(val+" ");
		}
	}

	
	//T.C-- O(n)  S.C-- O(1)
	private static void sort(int[] arr) {
		int cnt=0;
		for(int i:arr) {
			if(i==0) {
				arr[cnt++]=0;	
			}
		}
		
		for(int i=cnt;i<arr.length;i++) {
			arr[cnt++]=1;
		}
	}

}
