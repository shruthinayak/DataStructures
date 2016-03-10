package com.practice.list;


//forward case addition of linked list
//partition on x

public class Main {
	static int[] data = { 2, 2, 2, 3, 2, 12, 4, 6, 2, 2, 3};
	static Node head = linkedListDemo(data);

	public static void main(String[] args) {
		// addLinkedLists();
		// initiateDelete(3);
		 detectLoopStartPoint(head);
		 //reverseLinkedList(head);
		// listPalindrome(linkedListDemo(a));
		//traverseRecursive(head);
		//findMiddleNode(head.next.next, head);
		head.printList(head);
		Node temp = head.deleteFromList(head, 2);
		head.printList(temp);
	}
	
	private static void findMiddleNode(Node fast, Node slow){
		if(fast.next==null){
			slow = slow.next;
			System.out.println(slow.data);
			return;
		}
		else{
			fast=fast.next.next;
			slow=slow.next;
			findMiddleNode(fast, slow);
		}
	}
	
	private static void traverseRecursive(Node head){
		if(head==null){
			return;
		}
		System.out.print(head.data+",");
		traverseRecursive(head.next);
	}
	
	public static void kthElementFromEnd(Node head, int k) {
		Node node = head;
		while (node != null && k != 0) {
			node = node.next;
			k--;
		}
		Node n = head;
		while (node != null) {
			node = node.next;
			n = n.next;
		}
		System.out.println(n.data);
	}

	private static void initiateDelete(int n) {
		Node nodeTBD = head;
		while (n != 0) {
			n--;
			nodeTBD = nodeTBD.next;
		}
		nodeTBD.printList(head);
		deleteWithOnlyReference(nodeTBD);
	}

	private static Node result;
	
	static Node linkedListDemo(int[] a) {
		Node head = new Node();
		for (int d : a) {
			head.appendToTail(d);
		}
		//head.next.printList(head);
		return head.next;
	}

	private static int add(Node h, Node j) {
		if (h.next == null) {
			return h.data + j.data;
		} else {
			Node n = new Node(add(h.next, j.next));
			int sum = (h.data + j.data);
			Node x = new Node(sum);
			x.next = n;
			result = x;
			return 0;
		}
	}

	// Implement an algorithm to delete a node c only when access is given to it.
	private static void deleteWithOnlyReference(Node nodeTBD) {
		System.out.println("After deleting " + nodeTBD.data);
		Node nextPtr = nodeTBD.next;
		nodeTBD.data = nextPtr.data;
		nodeTBD.next = nextPtr.next;
		head.printList(head);
	}

	// detect beginning of a loop in a linked list
	private static void detectLoopStartPoint(Node head) {
		Node p = head;
		Node q = head.next.next;
		while (p != q) {
			p = p.next;
			q = q.next.next;
		}
		System.out.println("Detected a loop: Merge point at " + p.data);
		p = head;
		while (p.next != q) {
			p = p.next;
			q = q.next.next;
		}
		p.next = null;
		System.out.println("Beginning of the loop is " + p.data);
	}

	private static Node reverseLinkedList(Node head1) {
		Node temp = head1; //one
		head1 = head1.next; //two
		temp.next = null;
		System.out.println(head1.data);
		Node an = head1.next; //three
		while (head1.next != null) { 
			head1.next = temp; //two.next = one;
			temp = head1;//one = two
			head1 = an; //two = three
			an = head1.next; //three = three.next
			temp.printList(temp);
		}
		head1.next = temp;
		temp = head1;
		temp.printList(temp);
		return temp;
	}

	// To check if a list is palindrome
	private static void listPalindrome(Node head) {
		int size = 0;
		Node temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		int mid = size / 2;
		temp = head;
		int i = 0;
		while (i != mid) {
			temp = temp.next;
			i++;
		}
		Node temp2 = reverseLinkedList(temp);
		temp2.printList(temp2);
		temp = head;
		head.printList(head);
		while (temp2 != null) {
			if (temp2.data != temp.data) {
				System.out.println("Not a palindrome");
				return;
			}
			temp = temp.next;
			temp2 = temp2.next;
		}
		System.out.println("Yayy! A palindrome.");
	}
	
}
