package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Generic_Tree {

	Scanner scn=new Scanner(System.in);
	
	class node{
		int data;
		ArrayList<node> children=new ArrayList<>();
	}
	private node root;
	
	public Generic_Tree() {
		root=construct(null,-1);
	}

	private node construct(node parent, int ith) {
		
		if(parent==null) {
			System.out.println("Enter the data for root node");
		}else {
			System.out.println("Enter the data for "+ith+" child ?");
		}
		
		node nn=new node();
		int item=scn.nextInt();
		nn.data=item;
		
		System.out.println("Enter child of root node "+item+" --> ");
		
		int nc=scn.nextInt();
		
		for(int i=0;i<nc;i++) {
			node child=construct(nn, i);
			nn.children.add(child);
		}
		return nn;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(node rootnode) {
		int s=0;
		for(node child:rootnode.children) {
			s=s+size(child);
		}
		return s+1;
	}
	
	public int maxValue() {
		return maxValue(root);
	}
	
	private int maxValue(node rootnode) {
		
		int max=Integer.MIN_VALUE;
		for(node child:rootnode.children) {
			if(max<child.data) {
				int temp=maxValue(child);
				max=Math.max(max, temp);
			}
		}
		return Math.max(max, rootnode.data);
	}
	
	public boolean find(int val) {
		return find(root,val);
	}
	
	private boolean find(node rootnode, int val) {
		if(rootnode.data==val) {
			return true;
		}
		for(node child:rootnode.children) {
			boolean ans=find(child, val);
			if(ans)
				return true;
			
		}
		return false;
	}
	
	public int heigth() {
		return height(root);
	}
	
	private int height(node rootnode) {
		
		int sh=-1;
		for(node child:rootnode.children) {
			int th=height(child);
			if(th>sh) {
				sh=th;
			}
		}
		return sh+1;
	}
	
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(node rootnode) {
		System.out.print(rootnode.data+" ");
		for(node child:rootnode.children) {
			preOrder(child);
		}
		
	}
	
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(node rootNode) {
		
		
		for(node child:rootNode.children) {
			postOrder(child);
		}
		System.out.print(rootNode.data+" ");
		
		
	}
	
	public void mirror() {
		mirror(root);
	}
	
	private void mirror(node rootnode) {
		
		for(node child:rootnode.children) {
			mirror(child);
		}
		
		int i=0;
		int j=rootnode.children.size()-1;
		while(i<j) {
			node temp=rootnode.children.get(i);
			rootnode.children.set(i, rootnode.children.get(j));
			rootnode.children.set(j, temp);
			i++;
			j--;
		}
		
	}
	
	public void printAtLevelOrder(int k) throws Exception {
		if(k>root.children.size()+1) {
			throw new Exception("Invalid level! Please Enter valid level");
		}
		printAtLevelOrder(root,0,k);
	}
	
	private void printAtLevelOrder(node rootnode,int cnt,int k) {
		
		if(cnt==k) {
			System.out.print(rootnode.data+" ");
			return;
		}
		
		for(node child:rootnode.children) {
			printAtLevelOrder(child, cnt+1, k);
		}
		
	}
	
	public void levelOrder() {
		
		
		LinkedList<node> q=new LinkedList<>();
		q.addLast(root);
		q.addLast(null);
		
		while(!q.isEmpty()) {
			node rp=q.removeFirst();
			if(rp==null) {
				if(q.isEmpty()) {
					break;
				}
				System.out.println();
				q.addLast(null);
				continue;
			}
			System.out.print(rp.data+" ");
			
			for(node child:rp.children) {
				q.addLast(child);
			}
		}
		
	}
	
	public void levelOrder_2() {
		
		LinkedList<node> q=new LinkedList<>();
		LinkedList<node> h=new LinkedList<>();
		LinkedList<node> temp=new LinkedList<>();
		q.addLast(root);
		
		while(!q.isEmpty()) {
			node rp=q.removeFirst();
			System.out.print(rp.data+" ");
			for(node child:rp.children) {
				h.addLast(child);
			}
			if(q.isEmpty()) {
				System.out.println();
				temp=h;
				h=q;
				q=temp;
			}
		}
		
	}
	
	public void zigzagLevelOrder() {
		
		LinkedList<node> q=new LinkedList<>();
		LinkedList<node> h=new LinkedList<>();
		LinkedList<node> temp=new LinkedList<>();
		int count=0;
		q.addLast(root);
		
		while(!q.isEmpty()) {
			
			node rp=q.removeLast();
			System.out.print(rp.data+" ");
			if(count%2==0) {
				for(node child:rp.children) {
					h.addLast(child);
				}
			}else {
				for(int i=rp.children.size()-1;i>=0;i--) {
					h.addLast(rp.children.get(i));
				}
			}
			
			if(q.isEmpty()) {
				count++;
				System.out.println();
				temp=h;
				h=q;
				q=temp;
			}
			
		}
		
	}
	
	public void display() {
		display(root);
	}

	private void display(node rootnode) {
		
		System.out.print(rootnode.data+"-->");
		for(node child:rootnode.children) {
			System.out.print(child.data+", ");
		}
		if(rootnode.children.size()==0) {
			System.out.print(".");
		}
		System.out.println();
		for(node child:rootnode.children) {
			display(child);
		}
	}
	
}
