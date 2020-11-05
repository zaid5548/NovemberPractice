package Stack_Problem;

public class Client_Stack_Using_Queue_Pop_Efficient {

	public static void main(String[] args) throws Exception {
		Stack_using_Queue_PopEfficient q=new Stack_using_Queue_PopEfficient();
		q.push(10);
		q.push(20);
		q.push(30);
		q.push(40);
		q.push(50);
		System.out.println("Popped Element");
		System.out.println("Popped Element in Stack --> "+q.pop());
		System.out.println("Popped Element in Stack --> "+q.pop());
		q.push(60);
		q.push(70);
		System.out.println("Popped Element in Stack --> "+q.pop());
		System.out.println("Popped Element in Stack --> "+q.pop());
		System.out.println("Popped Element in Stack --> "+q.pop());
	}

}
