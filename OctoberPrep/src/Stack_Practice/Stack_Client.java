package Stack_Practice;

public class Stack_Client {

	public static void main(String[] strg) throws Exception {
		Stack s=new Stack(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.display();
		System.out.println("\n*****************************");
		System.out.println("Poped Element is "+s.pop());
//		s.push(60);
//		s.push(70);
		s.display();
		System.out.println("\nSize of Stack is "+s.size());
		System.out.println("Stack is Reverse Display but Real Stack remain same");
		s.reverseDisplay(s);
		Stack helper=new Stack(5);
		s.actualReverseDisplay(s,helper,0);
		System.out.println("\nStack is Actual Reverse");
		s.display();
		System.out.println("\nStack is Reverse Display but Real Stack remain same");
		s.reverseDisplay(s);
	}
	
	
}
