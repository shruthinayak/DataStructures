package com.practice.list;

class DNode {
	int data;
	DNode next;
	DNode prev;

	static DNode SortedInsert(DNode head, int data) {

		if (head == null) {
			head = new DNode();
			head.data = data;
			return head;
		}
		DNode temp = head;
		DNode prev = null;
		while (temp != null && temp.data < data){
			prev = temp;
			temp = temp.next;
			
		}
		DNode n = new DNode();
		n.data = data;

		if(temp==null){
			prev.next = n;
			n.prev = prev;
			return head;
		}
		
		if(temp.prev==null){
	        n.next = temp;
	        temp.prev = n;
	        return n;
	    }
	    
	    prev.next = n;
	    n.prev = prev;
	    n.next = temp;
	    temp.prev = n;
	    
	    return head;
		
	}

	public static void print(DNode h) {
		DNode temp = h;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	static DNode Reverse(DNode head) {
	    if(head == null)
	        return null;
	    if(head.next==null)
	        return head;
	    
	    while(head.next!=null){
	    	head = head.next;
	        DNode temp = head.prev;
	        head.prev = head.next;
	        head.next = temp;
	        
	    }
	    
	    return head;
	}
}