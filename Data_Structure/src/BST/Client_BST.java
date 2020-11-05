package BST;

public class Client_BST {

	public static void main(String[] args) {
		int[] arr= {10,20,30,40,50,60,70};
		Binary_Search_Tree bst=new Binary_Search_Tree(arr);
		bst.display();
		System.out.println("Item is Present in this Binary Search Tree ? "+bst.find(80));
		System.out.println("Maximum Element in this Binary Search Tree ? "+bst.max());
		bst.add(55);
		System.out.println("Added Element in BST");
		bst.display();
		bst.remove(40);
		bst.display();
	}

}
