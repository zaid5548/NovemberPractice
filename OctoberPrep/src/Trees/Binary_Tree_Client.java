package Trees;

public class Binary_Tree_Client {

	public static void main(String[] args) {
		Binary_Tree bt=new Binary_Tree();
		bt.display();
		System.out.println("Size of Binary Tree "+bt.size());
		System.out.println("Height of Binary Tree "+bt.height());
		System.out.println("maximum Element in Binary Tree "+bt.max());
		System.out.println("Given Elemnt is Present in Binary Tree--> "+bt.find(10));
		System.out.println("Diameter of Binary Tree "+bt.diameter());
		System.out.println("This Binary Tree is Balanced Or Not --> "+bt.isbalanced());
		System.out.println("PreOredr of Binary Tree");
		bt.preOrder();
		System.out.println("\nPostOredr of Binary Tree");
		bt.postOrder();
		System.out.println("\nInOredr of Binary Tree");
		bt.inOrder();
		System.out.println("\nPreOrder Print Data of Binary Tree Iteratively");
		bt.preOrder_2();
		System.out.println("\nPreOrder Print Data of Binary Tree Iteratively");
		bt.postOrder_2();
		System.out.println("\nInOrder Print Data of Binary Tree Iteratively");
		bt.inOrder_2();
		System.out.println();
//		System.out.println("Construct Binary Tree Using PreOrder and Inorder");
//		int[] pre= {10,20,40,50,30,70};
//		int[] in= {40,20,50,10,30,70};
//		bt.construct(pre, in);
//		bt.display();
		System.out.println("Construct Binary Tree Using PostOrder and Inorder");
		int[] post= {40,50,20,70,30,10};
		int[] in= {40,20,50,10,30,70};
		bt.construct_2(post, in);
		bt.display();
	}

}

// 10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
//10 true 20 true 40 false false true 50 false true 70 true 80 true 90 true 100 false false false false false true 30 false true 60 false false
