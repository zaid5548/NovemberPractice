package BST;

public class Binary_Search_Tree {

	class node{
		int data;
		
		node left;
		node right;
	}
	
	private node root;
	
	public Binary_Search_Tree(int[] arr) {
		root=construct(arr,0,arr.length-1);
//		root=construct_2(null,arr,0);
	}

	
	// if  input in Sorted Array
	private node construct(int[] arr, int lo, int hi) {
		
		//base case
		if(lo>hi) {
			return null;
		}
		
		int mid=(lo+hi)/2;
		
		//create node
		node nn=new node();
		nn.data=arr[mid];
		
		nn.left=construct(arr, lo, mid-1);
		nn.right=construct(arr, mid+1, hi);
		
		return nn;
		
	}
	
	
	// Construct BST -- IF Input in UnSorted Order
	// it is Wrong Check and Try Again
	public node construct_2(node parent,int[] arr,int cnt) {
		
		if(cnt>=arr.length) {
			return null;
		}
		
		int val=arr[cnt];
		node nn=new node();
		nn.data=val;
		if(parent==null) {
			parent=nn;
			construct_2(parent, arr, cnt+1);
		}else if(nn.data>parent.data) {
			parent.right=nn;
			construct_2(parent.right, arr, cnt+1);
		}else {
			parent.left=nn;
			construct_2(parent.left, arr, cnt+1);
		}
		
		return nn;
	}
	
	public boolean find(int val) {
		return find(root,val);
	}
	
	private boolean find(node rootnode,int val) {
		
		if(rootnode==null) {
			return false;
		}
		
		if(rootnode.data==val) {
			return true;
		}else if(rootnode.data>val) {
			return find(rootnode.left, val);
		}else {
			return find(rootnode.right, val);
		}
		
	}
	
	public int max() {
		return max(root);
	}
	
	private int max(node rootnode) {
		
		if(rootnode.right==null) {
			return rootnode.data;
		}
		
		return max(rootnode.right);
		
	}
	
	public void add(int val) {
		root= add(root,val);
	}
	
	private node add(node rootnode,int val) {
		
		if(rootnode==null) {
			node nn=new node();
			nn.data=val;
			return nn;
		}
		
		if(rootnode.data>val) {
			rootnode.left=add(rootnode.left, val);
		}else {
			rootnode.right=add(rootnode.right, val);
		}
		
		return rootnode;
	}
	
	public void remove(int val) {
		remove(this.root,null,true,val);
	}
	
	private void remove(node rootnode,node parent,boolean ilc,int val) {
		
		if(val>rootnode.data) {
			remove(rootnode.right, rootnode, false, val);
		}else if(val<rootnode.data) {
			remove(rootnode.left, rootnode, true, val);
		}else {
			if(rootnode.left==null && rootnode.right==null) {
				if(ilc) {
					parent.left=null;
				}else {
					parent.right=null;
				}
			}else if(rootnode.left==null && rootnode.right!=null) {
				if(ilc) {
					parent.left=rootnode.right;
				}else {
					parent.right=rootnode.right;
				}
			}else if(rootnode.left!=null && rootnode.right==null) {
				if(ilc) {
					parent.left=rootnode.left;
				}else {
					parent.right=rootnode.right;
				}
			}else {
				int max=max(rootnode.left);
				rootnode.data=max;
				
				remove(rootnode.left, rootnode, true, max);
			}
		}
		
	}
	
	public void display() {
		System.out.println("---------------");
		display(root);
		System.out.println("---------------");
	}

	private void display(node rootnode) {
		
		if(rootnode==null) {
			return;
		}
		
		String str="";
		
		//self
		if(rootnode.left==null) {
			str+=".";
		}else {
			str+=rootnode.left.data;
		}
		
		str+="-->"+rootnode.data+"<--";
		
		if(rootnode.right==null) {
			str+=".";
		}else {
			str+=rootnode.right.data;
		}
		
		System.out.println(str);
		
		//left Call
		display(rootnode.left);
		
		//right Call
		display(rootnode.right);
		
	}
	
}
