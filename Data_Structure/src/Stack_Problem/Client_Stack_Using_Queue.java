package Stack_Problem;

public class Client_Stack_Using_Queue {

	public static void main(String[] args) throws Exception {
		
		Stack_using_Queue_PushEfficient s=new Stack_using_Queue_PushEfficient();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		

	}

}
