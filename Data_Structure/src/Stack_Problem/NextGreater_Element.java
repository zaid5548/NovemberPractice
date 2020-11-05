package Stack_Problem;

import java.util.Stack;

public class NextGreater_Element {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 8, 6, 7, 5 };
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<arr.length;i++) {
			while(!stack.isEmpty() && arr[i]>stack.peek()) {
				int temp=stack.pop();
				System.out.println(arr[i]+"-->"+temp);
			}
			stack.push(arr[i]);
		}
		while(!stack.isEmpty()) {
			int temp=stack.pop();
			System.out.println(temp+"-1");
		}

	}
}
