package Stack_Practice;

import Queue_Problem.Queue;

public class Stack_Using_Queue_PopEfficient {

	Queue secondary=new Queue();
	public void push_2(int item) throws Exception {
		Queue helper=new Queue();
		while(secondary.size()>0) {
			helper.enQueue(secondary.deQueue());
		}
		secondary.enQueue(item);
		while(helper.size()>0) {
			secondary.enQueue(helper.deQueue());
		}
		
	}
	
	public int pop_2() throws Exception {
		
		return secondary.deQueue();
		
	}
	
}
