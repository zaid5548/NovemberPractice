package LinkedList_Problem;

public class LinkedList {

	class node{
		int val;
		node next;
	}
	
	private node head;
	private node tail;
	private int size=0;
	
	public void addLast(int item) {
		node nn=new node();
		nn.val=item;
		if(isEmpty()) {
			head=nn;
			tail=nn;
			size++;
		}else {
			tail.next=nn;
			tail=nn;
			size++;
		}
	}
	
	public void addFirst(int item) {
		node nn=new node();
		nn.val=item;
		if(isEmpty()) {
			addLast(item);
		}else {
			node temp=head;
			head=nn;
			head.next=temp;
			size++;
		}
	}
	
	public node getAtNode(int k) throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList Is Empty");
		}else if(k<0 || k>=size) {
			throw new Exception("Invalid Index");
		}else {
			node temp=head;
			for(int i=0;i<k;i++) {
				temp=temp.next;
			}
			return temp;
		}
	}
	
	public void addKthNode(int item,int k) throws Exception {
		
		if(k<0 || k>=size) {
			throw new Exception("Invalid Index");
		}else if(k==0) {
			addFirst(item);
		}else if(k==size-1) {
			addLast(item);
		}else {
			node nn=new node();
			nn.val=item;
			
			node pnode=getAtNode(k-1);
			node cnode=pnode.next;
			
			pnode.next=nn;
			nn.next=cnode;
			size++;
		}
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int getFirst() throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList Is Empty");
		}
		return head.val;
	}
	
	public int getLast() throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList Is Empty");
		}
		return tail.val;
	}
	
	public int getAt(int k) throws Exception {
		int temp;
		if(isEmpty()) {
			throw new Exception("LinkedList Is Empty");
		}else if(k<0 || k>=size) {
			throw new Exception("Index Is Invalid");
		}else if(k==0) {
			temp=getFirst();
		}else if(k==size-1) {
			temp=getLast();
		}else {
			node pnode=getAtNode(k);
			temp=pnode.val;
		}
		return temp;
	}
	
	public int removeLast() throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList is Empty");
		}
		
		int temp=tail.val;
		
		if(size==1) {
			head=null;
			tail=null;
			size--;
		}else {
			node pnode=getAtNode(size-2);
			pnode.next=null;
			tail=pnode;
			size--;
		}
		return temp;
	}
	
	public int removeFirst() throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList is Empty");
		}
		int temp=head.val;;	
		if(size==1) {
			head=null;
			tail=null;
			size--;
		}else {
			head=head.next;
			size--;
		}
		
		return temp;
		
	}
	
	public int removeKthNode(int k) throws Exception {
		int temp;
		if(isEmpty()) {
			throw new Exception("LinkedList Is Empty");
		}else if(k<0 || k>=size) {
			throw new Exception("Invalid Index");
		}else if(k==0) {
			temp=removeFirst();
		}else if(k==size-1) {
			temp=removeLast();
		}else {
			
			//get node
			node pnode=getAtNode(k-1);
			node cnode=pnode.next;
			temp=cnode.val;
			
			//atteched node
			pnode.next=cnode.next;
			size--;
		}
		return temp;
		
	}
	
	
	public void display() {
		node temp=head;
		while(temp!=null) {
			int data=temp.val;
			System.out.print(data+" ");
			temp=temp.next;
		}
	}
	
	
	public void RDI() throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList is Empty");
		}
		
		node temp=head;
		for(int i=size-1;i>=size/2;i--) {
			int safe=temp.val;
			node nd=getAtNode(i);
			int data=nd.val;
			temp.val=data;
			nd.val=safe;
			temp=temp.next;	
		}
		
	}

	
	public void RPI() throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList Is Empty");
		}
		
		node prev=null;
		node curr=head;
		while(curr!=null) {
			node temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		
		node temp=head;
		head=tail;
		tail=temp;
		
	}

	class mover{
		node left;
	}
	
	public void RDR() {
		mover m=new mover();
		m.left=head;
		node right=head;
		RDR(m,head,0);
	}

	private void RDR(mover m, node right, int cnt) {
		
		if(right==null) {
			return;
		}
		
		RDR(m,right.next,cnt+1);
		
		if(cnt>=size/2) {
			int ahead=m.left.val;
			m.left.val=right.val;
			right.val=ahead;
			
			m.left=m.left.next;
		}
		
	}
	
	
	public void RPR() throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList Is Empty");
		}
		
		RPR(null,head);
		node temp=head;
		head=tail;
		tail=temp;
		
	}

	private void RPR(node prev,node curr) {
		
		if(curr==null) {
			return;
		}
		
		RPR(curr, curr.next);
		curr.next=prev;
	}
	
	
	public void fold() {
		mover m=new mover();
		m.left=head;
		node right=head;
		fold(m,head,0);
	}
	
	private void fold(mover m,node right,int cnt) {
		
		if(right==null) {
			return;
		}
		
		fold(m, right.next, cnt+1);
		
		if(cnt>size/2) {
			node temp=m.left.next;
			m.left.next=right;
			right.next=temp;
			m.left=temp;
		}
		
		if(cnt==size/2) {
			tail=right;
			tail.next=null;
		}
		
	}

	public int middle() {
		node fp=head;
		node sp=head;
		
		while(fp!=null && fp.next!=null) {
			sp=sp.next;
			fp=fp.next.next;
		}
		return sp.val;
	}
	
	public void deleteMiddle() {
		
		node fp=head;
		node sp=head;
		node pre=head;
		while(fp!=null && fp.next!=null) {
			
			pre=sp;
			sp=sp.next;
			fp=fp.next.next;
			
		}
		pre.next=sp.next;
	}

	public boolean isPallindrome() {
		node left=head;
		node right=head;
		return isPallindrome(head);
	}
	
	node left;
	
	private boolean isPallindrome(node right) {
		left=head;
		if(right==null) {
			return true;
		}
		
		boolean first=isPallindrome(right.next);
		
		if(first==false) 
			return false;
		
		boolean second=(right.val==left.val);
		
		left=left.next;
		
		return second;
	}
	
	
	public boolean detectLoop() {
//		head.next.next.next.next.next=head;
		return detectLoop(head);
	}

	private boolean detectLoop(node head) {

		
		node fast=head;
		node slow=head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	public void removeLoop() {
		head.next.next.next.next.next=head;
//		System.out.println(detectLoop());
		removeLoop(head);
//		System.out.println(detectLoop());
	}
	
	private void removeLoop(node head) {
		
		node fast=head;
		node slow=head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				break;
			}
		}
		
		if(slow==fast) {
			
			if(fast==head) {
				while(slow.next!=fast) {
					slow=slow.next;
				}
				slow.next=null;
			}else {
				slow=head;
				while(slow.next!=fast.next) {
					slow=slow.next;
				}
				fast.next=null;
			}
			
		}
		return;
	}
	
	public void removeDuplicate() throws Exception {
		node curr=head;
		
		while(curr!=null) {
			node temp=curr;
			
			while(temp!=null && temp.val==curr.val) {
				temp=temp.next;
			}
			
			curr.next=temp;
			curr=curr.next;
			
		}
		
	}
	
}
