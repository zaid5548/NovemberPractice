package Queue_Problem;

public class Dynemic_Queue extends Queue{
	
	public void enQueue(int item) throws Exception {
		if(isFull()) {
			int[] na=new int[data.length*2];
			for(int i=0;i<size;i++) {
				int idx=(front+i)%data.length;
				na[i]=data[idx];
			}
			data=na;
			front=0;
		}
		super.enQueue(item);
	}
	
}
