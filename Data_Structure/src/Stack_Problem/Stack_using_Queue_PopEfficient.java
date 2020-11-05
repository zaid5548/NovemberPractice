package Stack_Problem;

import Queue_problem.Queue_1;

public class Stack_using_Queue_PopEfficient {

	Queue_1 primary=new Queue_1();
	
	public void push(int item) throws Exception {

		if(!primary.isEmpty()) {
			Queue_1 helper=new Queue_1();
			while(!primary.isEmpty()) {
				helper.Enqueue(primary.Dequeue());
			}
			primary.Enqueue(item);
			while(!helper.isEmpty()) {
				primary.Enqueue(helper.Dequeue());
			}
		}else {
			primary.Enqueue(item);
		}
	}
	
	public int pop() throws Exception {
		int temp=primary.Dequeue();
		return temp;
	}
	
}
