package Queue_Problem;

public class DynemicQueue_Client {

	public static void main(String[] args) throws Exception {
		Queue q=new Dynemic_Queue();
		for(int i=1;i<=10;i++) {
			q.enQueue(10*i);
		}
		q.display();
		System.out.println();
		for(int i=1;i<=5;i++) {
			System.out.println("Deleted Element is "+q.deQueue());
		}
		q.display();
		System.out.println();
		q.enQueue(110);
		q.enQueue(120);
		q.display();
		System.out.println("\n"+q.size);
	}

}
