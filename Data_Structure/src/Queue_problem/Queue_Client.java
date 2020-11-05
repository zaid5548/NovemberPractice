package Queue_problem;

//import java.util.Stack;

public class Queue_Client {

	public static void main(String[] args) throws Exception {
		Queue_1 q=new Queue_1();
		q.Enqueue(10);
		q.Enqueue(20);
		q.Enqueue(30);
		q.Enqueue(40);
		q.Enqueue(50);
//		q.Enqueue(60);
		q.display();
		System.out.println("********");
//		System.out.println("Deleted Element in Queue "+q.Dequeue());
//		System.out.println("Deleted Element in Queue "+q.Dequeue());
//		System.out.println("Deleted Element in Queue "+q.Dequeue());
//		System.out.println("Deleted Element in Queue "+q.Dequeue());
//		System.out.println("Deleted Element in Queue "+q.Dequeue());
//		System.out.println("Deleted Element in Queue "+q.Dequeue());
//		System.out.println("Queue is Full "+q.isFull());
//		System.out.println("Queue is Empty "+q.isEmpty());
//		q.Enqueue(60);
//		q.display();
//		q.display();
		System.out.println("Quesue is print Reverse");
		ActualReverse(q);
//		System.out.println("Queue is print Reverse Display");
//		DisplayQueuereverse(q, 0);
		System.out.println();
		System.out.println("print Actual Queue");
		q.display();
	}
	
	public static void ActualReverse(Queue_1 q) throws Exception {
		if(q.isEmpty()) {
			return;
		}
		int temp=q.Dequeue();
		ActualReverse(q);
		System.out.print(temp+" ");
		q.Enqueue(temp);
		
	}
	private static void DisplayQueuereverse(Queue_1 q,int cnt) throws Exception {
		if(q.size()==cnt) {
			return;
		}
		int temp=q.Dequeue();
		q.Enqueue(temp);
		DisplayQueuereverse(q, cnt+1);
		System.out.print(temp+" ");
	}

}
