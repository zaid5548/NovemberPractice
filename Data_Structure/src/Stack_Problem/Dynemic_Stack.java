package Stack_Problem;

public class Dynemic_Stack extends Stack_1{

	

	public void push(int item) throws Exception {
		if(isFull()) {
			int[] na=new int[data.length*2];
			for(int i=0;i<=tos;i++) {
				na[i]=data[i];
			}
			data=na;
		}
		super.push(item);

	}
	
}
