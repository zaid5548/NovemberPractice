package Stack_Practice;

public class Stack {

	protected int[] data;
	int tos;
	
	public Stack() {
		data=new int[5];
		tos=-1;
	}
	
	public Stack(int cap) {
		data=new int[cap];
		tos=-1;
	}
	
	public void push(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Stack is Full");
		}
		tos++;
		data[tos]=item;
	}
	
	public int pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		int temp=data[tos];
		data[tos]=0;
		tos--;
		return temp;
	}
	
	public int peek() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		return data[tos];
	}
	
	public boolean isEmpty() {
		return this.tos == -1;
	}
	
	public boolean isFull() {
		return tos==data.length-1;
	}
	
	public int size() {
		return this.tos+1;
	}
	
	//Reverse Display
	public void reverseDisplay(Stack s) throws Exception {
		if(isEmpty()) {
			return;
		}
		int temp=s.pop();
		reverseDisplay(s);
		s.push(temp);
		System.out.print(temp+" ");
	}
	
	//Actual Reverse Display
	public void actualReverseDisplay(Stack s,Stack h,int i) throws Exception {
		
		if(isEmpty()) {
			return;
		}
		
		int temp=s.pop();
		actualReverseDisplay( s, h, i+1);
		h.push(temp);
		if(i==0) {
			while(!h.isEmpty()) {
				s.push(h.pop());
			}
		}
	}
	
	
	public void display() {
		
		for(int i=tos;i>=0;i--) {
			System.out.print(data[i]+" ");
		}
		
	}
	
}
