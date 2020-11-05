package Linked_List_problem;

public class linked_List {
	
	public class node{
		int val;
		node next;
	}
	private node head;
	private node tail;
	private int size;
	
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
			
			nn.next=head;
			head=nn;
			size++;
		}
	}
	
	public void addKthNode(int item,int idx) throws Exception {
		
		if(idx<0 || idx>=size) {
			throw new Exception("Invalid index");
		}else if(idx==0) {
			addFirst(item);
		}else if(idx==size-1) {
			addLast(item);
		}else {

			//Create Node
			node nn=new node();
			nn.val=item;
			
			//get node
			node pnode=getAtNode(idx-1);
			node cnode=pnode.next;
			
			//Attached Node
			pnode.next=nn;
			nn.next=cnode;
			
			size++;
		}
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
		
		int temp=head.val;
		
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
	
	public int removeKthNode(int idx) throws Exception {
		int temp;
		if(idx<0 || idx>=size) {
			throw new Exception("Invalid Index");
		}else if(isEmpty()) {
			throw new Exception("LinkedList Is Empty");
		}else if(idx==0) {
			temp=removeFirst();
		}else if(idx==size-1) {
			temp=removeLast();
		}else {
			
			//Get Node
			node pnode=getAtNode(idx-1);
			node cnode=pnode.next;
			 temp=cnode.val;
			//Atteched node
			pnode.next=cnode.next;
			size--;
		}
		return temp;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int getAt(int idx) throws Exception {
		if(isEmpty()) {
			throw new Exception("Linked List is Empty");
		}
		if(idx<0 || idx>=size) {
			throw new Exception("Invalid Index");
		}
		node temp=head;
		for(int i=0;i<idx;i++) {
			temp=temp.next;
		}
		return temp.val;
	}
	
	public node getAtNode(int idx) throws Exception {
		if(isEmpty()) {
			throw new Exception("Linked List is Empty");
		}
		if(idx<0 || idx>=size) {
			throw new Exception("Invalid Index");
		}
		node temp=head;
		for(int i=0;i<idx;i++) {
			temp=temp.next;
		}
		return temp;
	}
	
	public int getFirst() throws Exception {
		if(isEmpty()) {
			throw new Exception("Linked List is Empty");
		}
		return head.val;
	}
	
	public int getLast() throws Exception {
		if(isEmpty()) {
			throw new Exception("Linked List is Empty");
		}
		return tail.val;
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
			int data=getAt(i);
			temp.val=data;
			nd.val=safe;
			temp=temp.next;
		}
		
	}
	
	class mover{
		node left;
	}
	
	public void RDR() {
		mover m=new mover();
		m.left=head;
		RDR(m,head,0);
	}
	
	private void RDR(mover m,node right,int cnt) {
		
		if(right==null) {
			return;
		}
		
		RDR(m, right.next, cnt+1);
		
		if(cnt>=size/2) {
			int ahead=m.left.val;
			m.left.val=right.val;
			right.val=ahead;
			
			m.left=m.left.next;
		}
		
	}
	
	public void RPI() throws Exception {
		if(isEmpty()) {
			throw new Exception("LinkedList is Empty");
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
	
	public void reversePrint() {
		node temp=head;
		reversePrint(temp);
	}
	private void reversePrint(node temp) {
		
		if(temp==null) {
			return;
		}
		
		reversePrint(temp.next);
		System.out.print(temp.val+" ");
		
	}
	
	public void fold() throws Exception {
		mover m=new mover();
		m.left=head;
		fold(m,head,0);
	}
	
	private void fold(mover m,node right,int cnt) throws Exception {
		
			if(right==null) {
				return;
			}
			
			fold(m, right.next, cnt+1);
			if(cnt>size/2) {
			node ahead=m.left.next;
			m.left.next=right;
			right.next=ahead;
			
			m.left=ahead;
			}
			
			if(cnt==size/2) {
				tail=right;
				tail.next=null;
			}
		
		}
	
	public int middle() {
		node sp=head;
		node fp=head;
		
		while(fp!=null && fp.next!=null) {
			sp=sp.next;
			fp=fp.next.next;
		}
		return sp.val;
	}
	
	public void deleteMiddle() {
		node sp=head;
		node fp=head;
		node pre=sp;
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
		boolean result = isPallindrome(left,right);
		return result;
//	    return isPalindrome(head);
	}
	
	

	/*We can use a fast and slow pointer to get the center of the list,
	then reverse the second list and compare two sublists. The time is O(n) and space is O(1).*/
	public boolean isPalindrome(node head) {
		 
	    if(head == null || head.next==null)
	        return true;
	 
	    //find list center
	    node fast = head;
	    node slow = head;
	 
	    while(fast.next!=null && fast.next.next!=null){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	 
	    node secondHead = slow.next;
	    slow.next = null;
	 
	    //reverse second part of the list
	    node p1 = secondHead;
	    node p2 = p1.next;
	 
	    while(p1!=null && p2!=null){
	    	node temp = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = temp;
	    }
	 
	    secondHead.next = null;
	 
	    //compare two sublists now
	    node p = (p2==null?p1:p2);
	    node q = head;
	    while(p!=null){
	        if(p.val != q.val)
	            return false;
	 
	        p = p.next;
	        q = q.next;
	 
	    }
	 
	    return true;
	}

	
	//this code check again
	private boolean isPallindrome(node left,node right) {
		
		if(right==null) {
			return true;
		}
		
		boolean first=isPallindrome(left,right.next);
		if(!first)
			return false;
			
		 //current left and right
        boolean second = (left.val == right.val);
 
        //move left to next
        left = left.next;
 
		
		return second;
	}
	
}
