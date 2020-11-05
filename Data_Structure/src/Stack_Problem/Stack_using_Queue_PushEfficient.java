package Stack_Problem;

import Queue_problem.Queue_1;

public class Stack_using_Queue_PushEfficient {

	Queue_1 primaryQueue = new Queue_1();

	public void push(int item) throws Exception {

		primaryQueue.Enqueue(item);

	}

	public int pop() throws Exception {

		Queue_1 helper = new Queue_1();
		while (primaryQueue.size() > 1) {
			helper.Enqueue(primaryQueue.Dequeue());
		}

		int temp = primaryQueue.Dequeue();

		while (!helper.isEmpty()) {
			primaryQueue.Enqueue(helper.Dequeue());
		}
		return temp;
	}
	
	public void display() {
		
	}

}
