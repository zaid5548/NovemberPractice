package Stack_Practice;

public class NearestSmallerLeft {

	public static void main(String[] args) throws Exception {
		
		int[] arr= {4,5,2,10,8};
		Stack s=new Stack();
		
		for(int i=0;i<arr.length;i++) {
			
			if(s.isEmpty()) {
				s.push(arr[i]);
				System.out.println(s.peek()+"-->-1");
			}else if(!s.isEmpty()&&arr[i]>s.peek()) {
				System.out.println(arr[i]+"-->"+s.peek());
				s.push(arr[i]);
			}else if(!s.isEmpty()&&arr[i]<s.peek()) {
				while(!s.isEmpty()&&arr[i]<s.peek()) {
					s.pop();
				}
				if(s.isEmpty()) {
					s.push(arr[i]);
					System.out.println(s.peek()+"-->-1");
				}else {
					System.out.println(arr[i]+"-->"+s.peek());
					s.push(arr[i]);
				}
			}
			
		}

	}

}
