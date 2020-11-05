package Queue_problem;

public class Client_Circular_Queue {

	public static void main(String[] args) throws Exception {
		Circular_Queue q=new Circular_Queue();
		q.Enqueue(10);
		q.Enqueue(20);
		q.Enqueue(30);
		q.Enqueue(40);
		q.Enqueue(50);
		q.display();
		System.out.println("********");
		System.out.println("Deleted Element in Queue "+q.Dequeue());
		System.out.println("Deleted Element in Queue "+q.Dequeue());
		q.Enqueue(60);
		q.Enqueue(70);
		System.out.println("Deleted Element in Queue "+q.Dequeue());
		System.out.println("Deleted Element in Queue "+q.Dequeue());
		q.Enqueue(80);
		q.Enqueue(90);
//		q.Enqueue(100);
		System.out.println("After some deletion and Add elemnet ");
		q.display();
	}

}
