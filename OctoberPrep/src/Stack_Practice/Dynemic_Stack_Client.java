package Stack_Practice;

public class Dynemic_Stack_Client{

	public static void main(String[] args) throws Exception {
		Stack d=new Dynemic_Stack();
		for(int i=1;i<=10;i++) {
			d.push(i*10);
		}
		d.display();
		System.out.println();
		for(int i=1;i<=5;i++) {
			System.out.println("Poped Element in Stack is "+d.pop());
		}
		d.display();
		System.out.println();
		d.push(110);
		d.display();
	}

}
