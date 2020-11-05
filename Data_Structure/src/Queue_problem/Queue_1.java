package Queue_problem;

import java.util.Stack;

public class Queue_1 {
	
	protected int data[];
	int front;
	int size;
	public Queue_1() {
		data=new int[5];
		front=0;
		size=0;
	}
	public Queue_1(int n) {
		data=new int[n];
		front=0;
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
		front=(front+1)%data.length;
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
	
//	getter
	public int size() {
		return size;
	}
	
//	Setter
	public void new_Size(int n) {
		size=n;
	}
	
	public void display() {
		for(int i=front;i<front+size;i++) {
			int idx=i%data.length;
			System.out.print(data[idx]+" ");
		}
	}
	
	
}
