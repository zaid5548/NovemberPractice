package Queue_Problem;

public class Queue_Cleint {

	public static void main(String[] args) throws Exception {
		Queue q=new Queue();
		q.enQueue(10);
		q.enQueue(20);
		q.enQueue(30);
		q.enQueue(40);
		q.enQueue(50);
		q.display();
		System.out.println("\n***************************");
		System.out.println("Deleted Element in Queue "+q.deQueue());
//		q.enQueue(60);
		System.out.println("Deleted Element in Queue "+q.deQueue());
		System.out.println("Deleted Element in Queue "+q.deQueue());
		System.out.println("-----------------------------");
		q.display();
//		System.out.println("\nReverse Queue Actual Display");
//		reverseActual(q);
//		System.out.println("\nReverse Queue display but real is remain same");
//	    reverseDisplay(q,0);
//		System.out.println("Real Queue is Reverse");
//		q.display();
	}
	
	//Queue Reverse Display Only
	public static void reverseDisplay(Queue q,int cnt) throws Exception {
		try {
		if(q.size()==cnt) {
			return;
		}
		int temp=q.deQueue();
		q.enQueue(temp);
		reverseDisplay(q, cnt+1);
		System.out.print(temp+" ");
		}catch(Exception e) {
			System.out.println("Exception in reverse display");
		}
	}
				
		
			
	
	//Queue Actual Reverse
	
		public static void reverseActual(Queue q) throws Exception {
			try {
			if(q.isEmpty()) {
				return;
			}
			int temp=q.deQueue();
			reverseActual(q);
			System.out.print(temp+" ");
			q.enQueue(temp);
			}catch(Exception e) {
				System.out.println("Exception in Actual Reverse");
			}
		}
		
		
		
}
