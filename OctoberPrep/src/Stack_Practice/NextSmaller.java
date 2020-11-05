package Stack_Practice;

public class NextSmaller {

	public static void main(String[] args) throws Exception {
		int[] arr= {1,5,2,1,3,6,10,9};
		Stack s=new Stack();
		for(int i=0;i<arr.length;i++) {
			while(!s.isEmpty() && arr[i]<s.peek()) {
				int temp=s.pop();
				System.out.println(temp+"--> "+arr[i]);
			}
			s.push(arr[i]);
		}
		while(!s.isEmpty()) {
			int temp=s.pop();
			System.out.println(temp+"--> "+"-1");
		}

	}

}
