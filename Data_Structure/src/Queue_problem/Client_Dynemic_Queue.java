package Queue_problem;

public class Client_Dynemic_Queue extends Dynemic_Queue{

	public static void main(String[] args) throws Exception {
		Dynemic_Queue dq=new Dynemic_Queue();
		for(int i=1;i<=8;i++) {
			dq.Enqueue(i*10);
		}
		dq.display();
	}

}
