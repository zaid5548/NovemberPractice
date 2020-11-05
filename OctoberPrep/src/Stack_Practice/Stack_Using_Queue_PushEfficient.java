package Stack_Practice;

import Queue_Problem.Queue;

public class Stack_Using_Queue_PushEfficient {

	// Push Efficient
	Queue primary = new Queue();

	public void push(int item) throws Exception {
		primary.enQueue(item);
	}

	public int pop() throws Exception {

			Queue helper = new Queue();
			while (primary.size() > 1) {
				helper.enQueue(primary.deQueue());
			}

			int temp = primary.deQueue();

			while (!helper.isEmpty()) {
				primary.enQueue(helper.deQueue());
			}
			return temp;
		
	}

}
