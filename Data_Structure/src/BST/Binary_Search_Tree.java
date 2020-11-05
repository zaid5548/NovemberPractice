package BST;

public class Binary_Search_Tree {

	public class Node{
		
		int data;
		Node left;
		Node right;
		
		
	}
	
	private Node root;
	
	public Binary_Search_Tree(int[] arr) {
		root=construct(arr,0,arr.length-1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		
		//base case
		if(lo>hi) {
			return null;
		}
		
		//mid
		int mid=(lo+hi)/2;
		
		//create node
		Node nn=new Node();
		nn.data=arr[mid];
		
		nn.left=construct(arr, lo, mid-1);
		nn.right=construct(arr, mid+1, hi);
		
		return nn;
		
	}
	
	public boolean find(int item) {
		return find(root,item);
	}
	
	private boolean find(Node node, int item) {
		if(node==null) {
			return false;
		}
		
		if(node.data==item) {
			return true;
		}else if(node.data>item) {
			return find(node.left, item);
		}else {
			return find(node.right, item);
		}		
	}
	
	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if(node.right==null) {
			return node.data;
		}
		return max(node.right);
	}
	
	public void add(int item) {
		root=add(root, item);
	}
	
	private Node add(Node node,int item) {
		if(node==null) {
			Node nn=new Node();
			nn.data=item;
			return nn;
		}
		
		if(node.data<item) {
			node.right=add(node.right, item);
		}else {
			node.left=add(node.left, item);
		}
		
		return node;
	}
	
	public void remove(int item) {
		remove(root,null,true,item);
	}

	private void remove(Node node, Node parent, boolean ilc, int item) {

		if(node==null) {
			return;
		}
		
		if(node.data<item) {
			remove(node.right, node, false, item);
		}else if(node.data>item) {
			remove(node.left, node, true, item);
		}else {
			if(node.left==null && node.right==null) {
				if(ilc)
				{
					parent.left=null;
				}else {
					parent.right=null;
				}
			}else if(node.left==null && node.right!=null) {
				if(ilc) {
					parent.left=node.right;
				}else {
					parent.right=node.right;
				}
			}else if(node.left!=null && node.right==null) {
				if(ilc) {
					parent.left=node.left;
				}else {
					parent.right=node.left;
				}
			}else {
				int max=max(node.left);
				node.data=max;
				
				remove(node.left, node, true, max);
			}
		}
		
	}

	public void display() {
		System.out.println("---------------");
		display(root);
		System.out.println("---------------");
	}

	private void display(Node node) {
		
		if(node==null) {
			return;
		}
		
		String str="";
		
		//self
		if(node.left==null) {
			str+=".";
		}else {
			str+=node.left.data;
		}
		
		str+="-->"+node.data+"<--";
		
		if(node.right==null) {
			str+=".";
		}else {
			str+=node.right.data;
		}
		
		System.out.println(str);
		
		//left Call
		display(node.left);
		
		//right Call
		display(node.right);
		
	}
	
}
