package Stack_Practice;

public class Stok_Span {

	public static void main(String[] args) throws Exception {
		int[] arr= {4,8,5,2,9,10};
		Stack s=new Stack();
		int[] res=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			
			while(!s.isEmpty() && arr[i]>arr[s.peek()]) {
				s.pop();
			}
			
			if(s.isEmpty()) {
				res[i]=i+1;
			}else {
				res[i]=i-s.peek();
			}
			
			s.push(i);
		}

		for(int val:res) {
			System.out.print(val+" ");
		}
	}

}