package Stack_Problem;

public class Stock_Span extends Stack_1{

	public static void main(String[] args) throws Exception {
		int[] arr= {10, 4, 5, 90, 120, 80 };
		int[] res=new int[arr.length];
		Stack_1 s=new Dynemic_Stack();
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
