package HEAP;

public class Client_Heap {

	public static void main(String[] args) {
		System.out.println("Hello Heap Programmer");
		heap h=new heap();
		h.add(10);
		h.display();
		
		h.add(20);
		h.display();
		
		h.add(30);
		h.display();
		
		h.add(5);
		h.display();
		
		h.add(35);
		h.display();

		System.out.println("Size of Heap "+h.size());
		System.out.println("Heap is Empty "+h.isEmpty());
		System.out.println("Removel Element is "+h.remove());
		h.display();
	}

}
