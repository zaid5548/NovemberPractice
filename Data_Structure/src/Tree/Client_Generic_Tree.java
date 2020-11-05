package Tree;

public class Client_Generic_Tree {

	public static void main(String[] args) throws Exception {

		Generic_Tree gt=new Generic_Tree();
		gt.display();
		System.out.println("Size of generic Tree "+gt.size());
//		System.out.println("height of Generic Tree "+gt.height());
//		System.out.println("maximum value in generic Tree "+gt.max());
//		System.out.println("Element is present in Generic Tree "+gt.find(10));
//		gt.mirror();
//		gt.display();
//		System.out.println("preorder of Generic Tree");
//		gt.preorder();
//		System.out.println("\npostorder of Generic Tree");
//		gt.postorder();
		System.out.println("\nPrint At Level Approach");
		gt.printAtLevel(2);
//		
	}

}

// 10 3 20 1 30 0 40 0 50 2 80 0 90 1 100 1 110 0