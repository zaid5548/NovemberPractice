package Stack_Practice;

import java.util.Stack;

public class Largest_Area_Histogram {

	public static void main(String[] args) {
		
//		int[] arr= {6,2,5,4,5,1,6};  // OutPut---> 12
		int[] arr= {2,1,5,6,2,3}; 	 // OutPut---> 10
		
		//NSE in dsx on the right
		int[] rb=new int[arr.length];
		Stack<Integer> s=new Stack<>();
		s.push(arr.length-1);
		rb[arr.length-1]=arr.length;
		
		for(int i=arr.length-2;i>=0;i--) {
			while(s.size()>0 && arr[i]<arr[s.peek()]) {
				s.pop();
			}
			if(s.size()==0) {
				rb[i]=arr.length;
			}else {
				rb[i]=s.peek();
			}
			s.push(i);
		}
		
		//NSE in dsx on the left
		
		int[] lb=new int[arr.length];
		s=new Stack<>();
		s.push(0);
		lb[0]=-1;
		
		for(int i=1;i<arr.length;i++) {
			while(s.size()>0 && arr[i]<arr[s.peek()]) {
				s.pop();
			}
			if(s.size()==0) {
				lb[i]=-1;
			}else {
				lb[i]=s.peek();
			}
			s.push(i);
		}
		
		//Area
		int maxArea=0;
		for(int i=0;i<arr.length;i++) {
			int width=rb[i]-lb[i]-1;
			int area=arr[i]*width;
			if(area>maxArea) {
				maxArea=area;
			}
		}
		System.out.println(maxArea);
		
	}

}
