package Tree;

public class Client_Binary_Tree {

	public static void main(String[] args) {
		Binary_Tree bt=new Binary_Tree();
//		bt.display();
//		System.out.println("Print PreOrder of Binary Tree");
//		bt.Preorder();
//		System.out.println("\nPrint PostOrder of Binary Tree");
//		bt.Postorder();
//		System.out.println("\nPrint Inorder of Binary Tree");
//		bt.Inorder();
//		System.out.println("\nSize of Binary Tree");
//		System.out.println(bt.size());
//		System.out.println("Size of Binary Tree");
//		System.out.println(bt.height());
//		System.out.println("Maximum Element of Binary Tree Node");
//		System.out.println(bt.max());
//		System.out.println("Given Element is Exist in this Binary Tree ?");
//		System.out.println(bt.find(60));
//		System.out.println("Diameter of Binary Tree ?");
//		System.out.println(bt.diameter());
//		System.out.println("Diameter2 of Binary Tree ?");
//		System.out.println(bt.diameter2());
//		System.out.println("Binary Tree is balanecd or not ?");
//		System.out.println(bt.isbalanced());
//		System.out.println("Binary Tree Iterative PreOrder");
//		bt.preorderItr();
//		System.out.println("\nBinary Tree Iterative PostOrder");
//		bt.postorderItr();
//		System.out.println("\nBinary Tree Iterative Inorder");
//		bt.inorderItr();
		System.out.println();
		System.out.println("Construct Binary Tree Using PreOrder and Inorder");
		int[] pre= {10,20,40,50,30,70};
		int[] in= {40,20,50,10,30,70};
		bt.construct(pre, in);
		bt.display();
	}

}

// 10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
//10 true 20 true 40 false false true 50 false true 70 true 80 true 90 true 100 false false false false false true 30 false true 60 false false


