package Stack_Problem;

public class Stack_1 {

	protected int[] data;
	int tos;

	public Stack_1() {
		this.data = new int[5];
		tos = -1;
	}

	public Stack_1(int cap) {
		data = new int[cap];
		this.tos = -1;
	}

	public void push(int item) throws Exception {
		if (isFull()) {
			throw new Exception("Stack is Full");
		}
		tos++;
		data[tos] = item;

	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int temp = data[tos];
		tos--;
		return temp;
	}

	public int peek() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[tos];
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		return this.tos == -1;
	}

//	isFull Function Check Again
	public boolean isFull() {
		return tos == data.length - 1;
	}

	public void display() {
		for (int i = tos; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}
		System.out.print("END\n");
	}

	public void reverseActual(Stack_1 s, Stack_1 helper, int i) throws Exception {
		if (isEmpty()) {
			return;
		}
		int temp = s.pop();
		reverseActual(s, helper, i + 1);
		helper.push(temp);
		if (i == 0) {
			while (!helper.isEmpty()) {
				s.push(helper.pop());
			}
		}
	}

	public void reverseDisplay(Stack_1 s) throws Exception {
		if (isEmpty()) {
			return;
		}
		int temp = s.pop();
		reverseDisplay(s);
		s.push(temp);
		System.out.print(temp + " ");
	}

}
