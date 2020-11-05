package Stack_Problem;

public class Client_Dynemic_Stack {

	public static void main(String[] args) throws Exception {
		Stack_1 dq=new Dynemic_Stack();
		for(int i=1;i<=8;i++) {
			dq.push(i*10);
			dq.display();
		}
		dq.display();
		System.out.println("deleted Element");
		while(!dq.isEmpty()) {
			dq.pop();
			dq.display();
		}
	}

}
