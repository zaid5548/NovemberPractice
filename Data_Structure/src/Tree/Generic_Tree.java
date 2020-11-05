package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Generic_Tree {
	
	Scanner scn=new Scanner(System.in);
	
	class node{
		int data;
		ArrayList<node> children=new ArrayList<>();
	}
	
	private node root;
	
	public Generic_Tree(){
		root=construct(null,-1);
	}
	
	private node construct(node parent,int ith) {
		
		if(parent==null) {
			System.out.println("Enter the data for root node");
		}else {
			System.out.println("Enter the data for "+ith+" child node");
		}

		node nn=new node();
		int item=scn.nextInt();
		nn.data=item;
		
		System.out.println("Enter Child for root "+item+" --> ");
		int nc=scn.nextInt();
		
		for(int i=0;i<nc;i++) {
			node child=construct(nn, i);
			nn.children.add(child);			
		}
		
		return nn;
	}
	
	public int size() {
		int s=size(root);
		return s;
	}
	
	private int size(node rootNode) {
		
		int s=0;
		for(node child:rootNode.children) {
			s=s+size(child);
		}
		return s+1;
		
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(node rootNode) {
		int sh=-1;
		for(node child:rootNode.children) {
			int th=height(child);
				if(th>sh) {
					sh=th;
				}
		}
		return sh+1;
	}
	
	public int max() {
		return max(root);
	}

	private int max(node rootNode) {
		int m=Integer.MIN_VALUE;
		for(node child:rootNode.children) {
			int temp=max(child);
			m=Math.max(m, temp);
		}
		return Math.max(m, rootNode.data);
	}
	
	public boolean find(int item) {
		return find(root,item);
	}

	private boolean find(node rootNode, int item) {
		if(rootNode.data==item) {
			return true;
		}
		
		for(node child:rootNode.children) {
			boolean ans=find(child, item);
			if(ans) {
				return true;
			}
		}
		
		return false;
	}

	public void mirror() {
		mirror(root);
	}
	
	private void mirror(node rootNode) {
		
		for(node child:rootNode.children) {
			mirror(child);
		}
		
		int i=0;
		int j=rootNode.children.size()-1;
		
		while(i<j) {
			node temp=rootNode.children.get(i);
			rootNode.children.set(i, rootNode.children.get(j));
			rootNode.children.set(j, temp);
			i++;
			j--;
		}
	}
	
	public void preorder() {
		preorder(root);
	}

	private void preorder(node rootNode) {
		
		System.out.print(rootNode.data+" ");
		for(node child:rootNode.children) {
			preorder(child);
		}
		
		
	}
	
	public void postorder() {
		postorder(root);
	}

	private void postorder(node rootNode) {
		
		
		for(node child:rootNode.children) {
			postorder(child);
		}
		System.out.print(rootNode.data+" ");
		
		
	}

	public void printAtLevel(int level) throws Exception {
		if(level>root.children.size()) {
			throw new Exception("Invalid level! Please Enter valid level");
		}
		printAtLevel(root,level,0);
	}
	
	private void printAtLevel(node rootNode, int level,int cnt) {
		
		if(cnt==level) {
			System.out.print(rootNode.data+" ");
			return;
		}
		
		for(node child:rootNode.children) {
			printAtLevel(child,level,cnt+1);
		}
	}

	public void display() {
		
		display(root);
		
	}

	private void display(node rootNode) {
		
		System.out.print(rootNode.data+"--> ");
		for(node child:rootNode.children) {
			System.out.print(child.data+", ");
		}
		if(rootNode.children.size()==0) {
			System.out.print(".");
		}
		System.out.println();
		for(node child:rootNode.children) {
			display(child);
		}
	}
}
