package Queue_Problem;

public class Circular_Queue {
	protected int[] data;
	int front;
	int size;
	public Circular_Queue() {
		data=new int[5];
		front=0;
		size=0;
	}
	public Circular_Queue(int cap) {
		data=new int[cap];
		front=0;
		size=0;
	}
	
	public void enQueue(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Queue is Full");
		}
		data[(size+front)%data.length]=item;
		size++;
	}
	
	public int deQueue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		int temp=data[front];
		front++;
		size--;
		return temp;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size==data.length;
	}
	
	public int getFront() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		return data[front];
	}
	
	
	
	//circular Queue Display
	public void display() {
		
		for(int i=0;i<size;i++) {
			int d=(front+i)%data.length;
			System.out.print(data[d]+" ");
		}
		
	}
}
