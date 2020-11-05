package Trees;

public class Client_Generic_Tree {

	public static void main(String[] args) throws Exception {
		Generic_Tree gt=new Generic_Tree();
		gt.display();
//		System.out.println("Size of Binary Tree "+gt.size());
//		System.out.println("Maximum Value inthis Generic Tree Element "+gt.maxValue());
//		System.out.println("Given Item is Present In This Generic Tree --> "+gt.find(70));
//		System.out.println("Height of generic tree --> "+gt.heigth());
//		System.out.println("Print Data of Generic Tree in PreOrder ");
//		gt.preOrder();
//		System.out.println();
//		System.out.println("Print Data of Generic Tree in PostOrder ");
//		gt.postOrder();
//		System.out.println();
//		System.out.println("Mirror print of Generic Tree");
//		gt.mirror();
//		gt.display();
//		System.out.println("Print LevelOrder of Generic Tree");
//		gt.printAtLevelOrder(2);
//		System.out.println("Print Generic Tree In LevelOrder");
//		gt.levelOrder();
//		System.out.println("\nPrint Generic Tree In LevelOrder_2");
//		gt.levelOrder_2();
		System.out.println("Print Generic Tree In ZigZag Order");
		gt.zigzagLevelOrder();
	}

}

//10 3 20 1 30 0 40 0 50 2 80 0 90 1 100 1 110 0
//10 3 20 3 50 2 80 0 90 0 60 1 100 0 70 1 110 1 120 1 130 0 30 1 140 0 40 1 150 2 160 0 170 0