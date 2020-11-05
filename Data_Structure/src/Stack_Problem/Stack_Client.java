package Stack_Problem;

public class Stack_Client {

	public static void main(String[] args) throws Exception {
		Stack_1 s=new Stack_1(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
//		s.push(60);
		s.display();
//        Stack_1 helper = new Stack_1();
		//		System.out.println("*********");
//		System.out.println("deleted Element is "+s.pop());
//		System.out.println("deleted Element is "+s.pop());
//		System.out.println("deleted Element is "+s.pop());
//		System.out.println("deleted Element is "+s.pop());
//		System.out.println("deleted Element is "+s.pop());
//		System.out.println("deleted Element is "+s.pop());
//		s.display();
//		System.out.println("\nStack is Empty "+s.isEmpty());
//		System.out.println("Stack is Full "+s.isFull());
//		s.push(60);
//		s.display();
//		s.push(70);
//		System.out.println("\nAfter Reverse Stack Element");
//		Stack_1 helper=new Stack_1(5);
//		s.reverse(s,helper,0);
//		s.display();
//		s.reverseActual(s, helper, 0);
//      System.out.println("Stack is reverse but Real Must Remain same");
//      s.reverseDisplay(s);
//      System.out.println("\nAfter print reverse Stack print the Real Stack Element");
//		s.display();
//		System.out.println("Print Actual reverse Stack");
//		reverseActual(s, helper);
//		s.display();
		

	}
	
	public static void reverseActual(Stack_1 s,Stack_1 h) throws Exception {
		if(s.isEmpty()) {
			ActualReverse(s, h);
			return;
		}
		h.push(s.pop());
		reverseActual(s, h);
		
	}
	
	public static void ActualReverse(Stack_1 s,Stack_1 h) throws Exception {
		
		if(h.isEmpty()) {
			return;
		}
		
		int temp=h.pop();
		ActualReverse(s, h);
		s.push(temp);
		
	}
	
	

}
