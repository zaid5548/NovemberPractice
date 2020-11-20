package BST;

public class Client_BST {

	public static void main(String[] args){
		int[] arr= {10,20,30,40,50,60,70};
		Binary_Search_Tree bst=new Binary_Search_Tree(arr);
		bst.display();
		System.out.println("Element is Present in BST "+bst.find(50));
		bst.add(55);
		bst.display();
		bst.remove(60);
		System.out.println("**************");
		bst.display();
	}
	
}
