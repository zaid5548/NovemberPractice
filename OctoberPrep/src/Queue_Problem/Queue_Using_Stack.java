package Queue_Problem;

import Stack_Practice.Stack;


public class Queue_Using_Stack{

	
//	EnQueue Efficient
	Stack primary=new Stack();
	public void enQueue_1(int item) throws Exception {
		
		primary.push(item);
		
	}
	
	public int deQueue_1() throws Exception {
		
		Stack helper=new Stack();
		while(primary.size()>1) {
			helper.push(primary.pop());
		}
		
		int temp=primary.pop();
		
		while(helper.size()>0) {
			primary.push(helper.pop());
		}
		return temp;
	}
	
	
//	DeQueue Efficient
	Stack secondary=new Stack();

	public void enQueue_2(int item) throws Exception {
		
		Stack helper=new Stack();
		while(!secondary.isEmpty()) {
			helper.push(secondary.pop());
		}
		
		secondary.push(item);
		
		while(!helper.isEmpty()) {
			secondary.push(helper.pop());
		}
		
	}
	
	public int deQueue_2() throws Exception {
		return secondary.pop();
	}
	
}
