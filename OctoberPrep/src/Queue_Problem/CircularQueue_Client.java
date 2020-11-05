package Queue_Problem;

public class CircularQueue_Client {

	public static void main(String[] args) throws Exception {
		Circular_Queue q=new Circular_Queue();
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(40);
		q.enQueue(50);
		q.display();
		System.out.println("\n***************************");
		System.out.println("Deleted Element in Queue "+q.deQueue());
		q.enQueue(60);
//		System.out.println("Deleted Element in Queue "+q.deQueue());
//		System.out.println("Deleted Element in Queue "+q.deQueue());
		System.out.println("-----------------------------");
		q.display();
	}

}
