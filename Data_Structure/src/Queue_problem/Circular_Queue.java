package Queue_problem;

public class Circular_Queue {

	protected int data[];
	int front=0;
	int size;
	public Circular_Queue() {
		data=new int[5];
		size=0;
	}
	public Circular_Queue(int n) {
		data=new int[n];
		size=0;
	}
	public void Enqueue(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Queue is Full");
		}
		data[(size+front)%data.length]=item;
		size++;
	}
	public int Dequeue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int temp=data[front];
		front++;
		size--;
		return temp;
	}
	public int getFront() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		return data[front];
	}
	public boolean isEmpty() {
		return size==0;
	}
	public boolean isFull() {
		return size==data.length;
	}
	
	public void display() {
		for(int i=0;i<size;i++) {
			int d=(front+i)%data.length;
			System.out.print(data[d]+" ");
		}
	}
	
}
