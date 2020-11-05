package Trees;

import java.util.Scanner;
import java.util.Stack;

public class Binary_Tree {
	Scanner scn=new Scanner(System.in);
	class node{
		int data;
		node left;
		node right;
	}
	private node root;
	
	public  Binary_Tree() {
		root=construct(null,true);
	}
	private node construct(node parent,boolean child) {
		if(parent==null) {
			System.out.println("Enter data for root node");
		}else {
			if(child==true) {
				System.out.println("Enter data for left child of "+parent.data+" ?");
			}else {
				System.out.println("Enter data for right child of "+parent.data+" ?");
			}
		}
		
		node nn=new node();
		int item=scn.nextInt();
		nn.data=item;
		System.out.println("Is Left Child of "+nn.data+" ?");
		boolean isLeft=scn.nextBoolean();
		if(isLeft) {
			nn.left=construct(nn,true);
		}
		System.out.println("Is Right CHild of "+nn.data+" ?");
		boolean isRight=scn.nextBoolean();
		if(isRight) {
			nn.right=construct(nn, false);
		}
		return nn;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(node parent) {
		
		if(parent==null) {
			return 0;
		}
		
		int s=0;
		s+=size(parent.left);
		s+=size(parent.right);
		
		return s+1;
		
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(node parent) {
		
		if(parent==null) {
			return -1;
		}
		
		int leftHeight=height(parent.left);
		int rightHeight=height(parent.right);
		
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public int max() {
		return max(root);
	}
	
	private int max(node parent) {
		if(parent==null) {
			return 0;
		}
		int lm=max(parent.left);
		int rm=max(parent.right);
		
		return Math.max(parent.data, Math.max(lm, rm));
	}
	
	public boolean find(int val) {
		return find(root,val);
	}
	
	private boolean find(node parent,int val) {
		if(parent==null) {
			return false;
		}
		if(parent.data==val) {
			return true;
		}
		boolean lf=find(parent.left, val);
		boolean rf=find(parent.right, val);
		
		return lf||rf;
		
	}
	
	public int diameter() {
		return diameter(root);
	}
	
	private int diameter(node parent) {
		if(parent==null) {
			return -1;
		}
		int ld=diameter(parent.left);
		int rd=diameter(parent.right);
		int sd=(height(parent.left))+(height(parent.right))+2;
		
		return Math.max(sd, Math.max(ld, rd)); 
		
	}
	
	public boolean isbalanced() {
		return isbalanced(root);
	}
	
	private boolean isbalanced(node parent) {
		if(parent==null) {
			return true;
		}
		
		boolean lb=isbalanced(parent.left);
		boolean rb=isbalanced(parent.right);
		
		int sb=(height(parent.left))-(height(parent.right));
		
		return lb && rb &&  (sb==-1 || sb==0 || sb==1);
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(node parent) {
		if(parent==null) {
			return;
		}
		System.out.print(parent.data+" ");
		preOrder(parent.left);
		preOrder(parent.right);
		
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(node parent) {
		if(parent==null) {
			return;
		}
		postOrder(parent.left);
		postOrder(parent.right);
		System.out.print(parent.data+" ");
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(node parent) {
		if(parent==null) {
			return;
		}
		inOrder(parent.left);
		System.out.print(parent.data+" ");
		inOrder(parent.right);
	}
	
	//PreOrder Iteratively
	class pair{
		node rootNode;
		boolean sd;
		boolean ld;
		boolean rd;
	}
	
	public void preOrder_2() {
		Stack<pair> s=new Stack<>();
		pair np=new pair();
		np.rootNode=root;
		s.push(np);
		while(!s.isEmpty()) {
			pair rp=s.peek();
			if(rp.rootNode==null) {
				s.pop();
				continue;
			}
			if(rp.sd==false) {
				System.out.print(rp.rootNode.data+" ");
				rp.sd=true;
			}else if(rp.ld==false) {
				pair temp=new pair();
				temp.rootNode=rp.rootNode.left;
				s.push(temp);
				rp.ld=true;
			}else if(rp.rd==false) {
				pair temp=new pair();
				temp.rootNode=rp.rootNode.right;
				s.push(temp);
				rp.rd=true;
			}else {
				s.pop();
			}
		}
	}
	
	//PostOrder Iteratively
	
	public void postOrder_2() {
		Stack<pair> s=new Stack<>();
		pair np=new pair();
		np.rootNode=root;
		s.push(np);
		while(!s.isEmpty()) {
			pair rp=s.peek();
			if(rp.rootNode==null) {
				s.pop();
				continue;
			}
			if(rp.ld==false) {
				pair temp=new pair();
				temp.rootNode=rp.rootNode.left;
				s.push(temp);
				rp.ld=true;
			}else if(rp.rd==false) {
				pair temp=new pair();
				temp.rootNode=rp.rootNode.right;
				s.push(temp);
				rp.rd=true;
			}else if(rp.sd==false) {
				System.out.print(rp.rootNode.data+" ");
				rp.sd=true;
			}else {
				s.pop();
			}
			
		}
	}
	
	//InOrder Iteratively
	
		public void inOrder_2() {
			Stack<pair> s=new Stack<>();
			pair np=new pair();
			np.rootNode=root;
			s.push(np);
			while(!s.isEmpty()) {
				pair rp=s.peek();
				if(rp.rootNode==null) {
					s.pop();
					continue;
				}
				if(rp.ld==false) {
					pair temp=new pair();
					temp.rootNode=rp.rootNode.left;
					s.push(temp);
					rp.ld=true;
				}else if(rp.sd==false) {
					System.out.print(rp.rootNode.data+" ");
					rp.sd=true;
				}else if(rp.rd==false) {
					pair temp=new pair();
					temp.rootNode=rp.rootNode.right;
					s.push(temp);
					rp.rd=true;
				}else {
					s.pop();
				}
				
			}
		}
	
	// Construct Tree Using PreOrder and InOrder
		public void construct(int[] pre,int[] in) {
			root=construct(pre,0,pre.length-1,in,0,in.length-1);
		}
		
		private node construct(int[] pre,int plo,int phi,int[] in,int ilo,int ihi) {
			
			if(plo>phi || ilo>ihi) {
				return null;
			}
			int idx=-1;
			node rootnode=new node();
			rootnode.data=pre[plo];
			for(int i=ilo;i<=ihi;i++) {
				if(rootnode.data==in[i]) {
					idx=i;
				}
			}
			
			int nel=idx-ilo;
			
			rootnode.left=construct(pre, plo+1, plo+nel, in, ilo, idx-1);
			rootnode.right=construct(pre, plo+nel+1, phi, in, idx+1, ihi);
			
			return rootnode;
		}
		
//		Construct Tree Using PostOrder and InOrder
		public void construct_2(int[] post,int[] in) {
			root=construct_2(post,0,post.length-1,in,0,in.length-1);
		}
		
		private node construct_2(int[] post,int plo,int phi,int[] in,int ilo,int ihi) {
			
			if(plo>phi || ilo>ihi) {
				return null;
			}
			
			node rootnode=new node();
			rootnode.data=post[phi];
			
			int idx=-1;
			for(int i=ilo;i<=ihi;i++) {
				if(rootnode.data==in[i]) {
					idx=i;
				}
			}
			
			int nel=idx-ilo;
			int ner=ihi-idx;
			
			rootnode.left=construct_2(post, plo, plo+nel-1, in, ilo, idx-1);
			rootnode.right=construct_2(post, phi-ner, phi-1, in, idx+1, ihi);
			return rootnode;
		}
		
		
	public void display() {
		display(root);
	}
	private void display(node parent) {
		
		if(parent == null) {
			return;
		}
		
		String str="";
		
		if(parent.left!=null) {
			str+=parent.left.data;
		}else {
			str+=".";
		}
		
		str+="<--"+parent.data+"-->";
		
		if(parent.right!=null) {
			str+=parent.right.data;
		}else {
			str+=".";
		}
		
		System.out.println(str);
		display(parent.left);
		display(parent.right);
		
	}
	
}
