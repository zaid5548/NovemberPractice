package Tree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Binary_Tree {
	Scanner scn = new Scanner(System.in);

	public class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public Binary_Tree() {
		root = construct(null, true);
	}

	private Node construct(Node parent, Boolean isLeftChild) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			if (isLeftChild == true) {
				System.out.println("Enter the data for left Child " + parent.data);
			} else {
				System.out.println("Enter the data for right Child " + parent.data);
			}
		}

		// create node
		Node nn = new Node();
		int item = scn.nextInt();
		nn.data = item;

		System.out.println("is Left child of ?" + nn.data);
		boolean b = scn.nextBoolean();
		if (b) {
			nn.left = construct(nn, true);
		}

		System.out.println("is Right child of ? " + nn.data);
		boolean c = scn.nextBoolean();
		if (c) {
			nn.right = construct(nn, false);
		}

		return nn;
	}

	public void Preorder() {
		preorder(root);
	}

	private void preorder(Node node) {

		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);

	}

	public void Postorder() {
		postorder(root);
	}

	private void postorder(Node node) {

		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");

	}

	public void Inorder() {
		inorder(root);
	}

	private void inorder(Node node) {

		if (node == null) {
			return;
		}

		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		int s = 0;
		s += size(node.left);
		s += size(node.right);
		return s + 1;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int leftheight = height(node.left);
		int rightHeight = height(node.right);

		return Math.max(leftheight, rightHeight) + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return 0;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node == null) {
			return false;
		}
		if (node.data == item) {
			return true;
		}
		return find(node.left, item) || find(node.right, item);
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {

		if (node == null) {
			return -1;
		}

		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sd = (height(node.left) + height(node.right)) + 2;

		return Math.max(sd, Math.max(ld, rd));
	}

	class diaPair {
		int d;
		int ht;
	}

	public int diameter2() {
		return diameter2(root).d;
	}

	private diaPair diameter2(Node node) {

		if (node == null) {
			return new diaPair();
		}

		diaPair lpair = diameter2(node.left);
		diaPair rpair = diameter2(node.right);

		diaPair spair = new diaPair();
		spair.ht = Math.max(lpair.ht, rpair.ht) + 1;

		int self = lpair.ht + rpair.ht;

		spair.d = Math.max(self, Math.max(lpair.d, rpair.d));

		return spair;

	}

	public boolean isbalanced() {
		return isbalanced(root);
	}

	private boolean isbalanced(Node node) {

		if (node == null) {
			return true;
		}

		boolean isL = isbalanced(node.left);
		boolean isR = isbalanced(node.right);
		int bf = (height(node.left) - height(node.right));

		return isL && isR && (bf == -1 || bf == 0 || bf == 1);
	}

	class pair{
		Node node;
		boolean sd;
		boolean ld;
		boolean rd;
	}
	
	public void preorderItr() {
		
		Stack<pair> s=new Stack<>();
		pair np=new pair();
		np.node=root;
		s.push(np);
		while(!s.isEmpty()) {
			pair rp=s.peek();
			
			if(rp.node==null) {
				s.pop();
				continue;
			}
			
			if(rp.sd==false) {
				System.out.print(rp.node.data+" ");
				rp.sd=true;
			}else if(rp.ld==false) {
				pair temp=new pair();
				temp.node=rp.node.left;
				s.push(temp);
				
				rp.ld=true;
			}else if(rp.rd==false) {
				pair temp=new pair();
				temp.node=rp.node.right;
				s.push(temp);
				
				rp.rd=true;
			}else {
				s.pop();
			}
			
		}
		
	}
	
	public void postorderItr() {
		Stack<pair> s=new Stack<>();
		pair np=new pair();
		np.node=root;
		s.push(np);
		while(!s.isEmpty()) {
			
			pair rp=s.peek();
			
			if(rp.node==null) {
				s.pop();
				continue;
			}
			
			if(rp.ld==false) {
				pair temp=new pair();
				temp.node=rp.node.left;
				s.push(temp);
				
				rp.ld=true;
			}else if(rp.rd==false) {
				pair temp=new pair();
				temp.node=rp.node.right;
				s.push(temp);
				
				rp.rd=true;
			}else if(rp.sd==false) {
				System.out.print(rp.node.data+" ");
				rp.sd=true;
			}else {
				s.pop();
			}
			
		}
	}
	
	public void inorderItr() {
		Stack<pair> s=new Stack<>();
		pair np=new pair();
		np.node=root;
		s.push(np);
		while(!s.isEmpty()) {
			
			pair rp=s.peek();
			
			if(rp.node==null) {
				s.pop();
				continue;
			}
			
			if(rp.ld==false) {
				pair temp=new pair();
				temp.node=rp.node.left;
				s.push(temp);
				
				rp.ld=true;
			}else if(rp.sd==false) {
				System.out.print(rp.node.data+" ");
				rp.sd=true;
			}else if(rp.rd==false) {
				pair temp=new pair();
				temp.node=rp.node.right;
				s.push(temp);
				
				rp.rd=true;
			}else {
				s.pop();
			}
			
		}
	}
	
	public void construct(int[] pre,int[] in) {
		root=construct(pre,0,pre.length-1,in,0,in.length-1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		
		if(plo>phi || ilo>ihi) {
			return null;
		}
		
		Node node=new Node();
		node.data=pre[plo];
		
		int idx=-1;
		for(int i=ilo;i<=ihi;i++) {
			
			if(node.data==in[i]) {
				
				idx=i;
				break;
			}
			
		}
		int nel=idx-ilo;
		node.left=construct(pre, plo+1, plo+nel, in, ilo, idx-1);
		node.right=construct(pre, plo+nel+1, phi, in, idx+1, ihi);
		return node;
		
	}

	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += "<--" + node.data + "-->";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

}
