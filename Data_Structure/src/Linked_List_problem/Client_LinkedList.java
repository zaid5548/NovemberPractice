package Linked_List_problem;

public class Client_LinkedList {

	public static void main(String[] args) throws Exception {
		linked_List ll=new linked_List();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
//		ll.addLast(40);
//		ll.addLast(50);
//		ll.addLast(60);
		ll.addLast(20);
		ll.addLast(10);
		ll.display();
//		System.out.println();
//		System.out.println("Linked List is Empty "+ll.isEmpty());
//		System.out.println("First Element of LinkedList "+ll.getFirst());
//		System.out.println("Last Element of LinkedList "+ll.getLast());
//		ll.addFirst(70);
//		ll.display();
//		System.out.println();
//		ll.addKthNode(120, 5);
//		ll.display();
//		System.out.println("\nRemove Last");
//		System.out.println(ll.removeLast());
//		ll.display();
//		System.out.println("\n Remove First");
//		System.out.println(ll.removeFirst());
//		ll.display();
//		System.out.println("\n Remove First");
//		System.out.println(ll.removeFirst());
//		ll.display();
//		System.out.println("\nNode at Given Index"+ll.getAt(4));
//		System.out.println("Remove node At Index");
//		System.out.println(ll.removeKthNode(5));
//		ll.display();
//		System.out.println("\nReverse data Iteratively");
//		ll.RDI();
//		ll.display();
//		System.out.println("\nReverse data Recursivly");
//		ll.RDR();
//		ll.display();
//		ll.addLast(70);
//		System.out.println();
//		ll.display();
//		System.out.println("\nreverse Pointer Iteratively");
//		ll.RPI();
//		ll.display();
//		ll.addLast(70);
//		ll.display();
//		System.out.println("Fold the LinkedList");
//		ll.fold();
//		ll.display();
//		System.out.println("\nMiddle of Linked List --> "+ll.middle());
//		System.out.println();
//		ll.deleteMiddle();
//		ll.display();
		
//		System.out.println("\nLinkedList Reverse Print only ");
//		ll.reversePrint();
//		System.out.println("\nActual LinkedList");
//		ll.display();
		
		System.out.println("\nCheck LinkedList is pallindrome or not ");
		System.out.println(ll.isPallindrome());
	}

}
