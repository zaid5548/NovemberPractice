package Stack_Practice;

public class NearestGreaterToLeft {

	public static void main(String[] args) throws Exception {
		
		int[] arr= {100,80,60,70,60,75,85,343,22,221,324,445,54,65,7};
//		int[] arr={1,3,2,4};
		Stack s=new Stack();
		for(int i=0;i<arr.length;i++) {
			
			if(s.isEmpty()) {
				s.push(arr[i]);
				System.out.println(s.peek()+"-->-1");
			}else if(!s.isEmpty() && arr[i]<s.peek()) {
				System.out.println(arr[i]+"-->"+s.peek());
				s.push(arr[i]);
			}else if(!s.isEmpty() && arr[i]>s.peek()) {
				while(!s.isEmpty() && arr[i]>s.peek()) {
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