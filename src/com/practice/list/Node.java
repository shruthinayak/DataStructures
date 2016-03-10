package com.practice.list;

public class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	public Node() {

	}

	Node appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
		return end;
	}

	Node deleteFromList(Node head, int d) {
		Node pointer = head;
		
		while (pointer != null) {

			if (pointer.data != d) {
				pointer = pointer.next;
				continue;
			} else{
				if(pointer==head){
					head = head.next;
					pointer = pointer.next;
				}
				else pointer = pointer.next.next;
			}
				
		}
		return head;
	}

	void printList(Node head) {
		Node pointer = head;
		while (pointer != null) {
			System.out.print(pointer.data + "->");
			pointer = pointer.next;
		}
		System.out.println();
	}

	Node InsertNth(Node head, int data, int position) {

		Node newNode = new Node(data);

		if (head == null) {
			return newNode;
		}
		Node temp = head;
		Node prev = null;
		for (int find = 0; find < position; find++) {
			prev = temp;
			temp = temp.next;
			if (temp == null) {
				break;
			}
		}
		if (position == 0) {
			newNode.next = head;
			head = newNode;
			return head;
		} else if (temp == null) {
			prev.next = newNode;
			return head;
		} else {
			newNode.next = temp;
			prev.next = newNode;
			return head;
		}

	}

	Node Delete(Node head, int position) {
		// Complete this method
		if (head == null) {
			return null;
		}
		if (position == 0) {
			return head.next;
		}
		Node temp = head;
		Node prev = null;
		for (int i = 0; i < position; i++) {
			prev = temp;
			temp = temp.next;
			if (temp == null) {
				return null;
			}
		}
		prev.next = temp.next;
		return head;
	}

	int HasCycle(Node head) {
		Node one = head;
		Node two = head;
		while (one != null && two != null && two.next != null) {
			one = one.next;
			two = two.next.next;
			if (one == two) {
				return 1;
			}
		}
		return 0;
	}

	int FindMergeNode(Node headA, Node headB) {
		// Complete this function
		// Do not write the main method.
		int countA = 0;
		int countB = 0;
		Node tempA = headA;
		Node tempB = headB;
		while (tempA != null) {
			tempA = tempA.next;
			countA++;
		}
		while (tempB != null) {
			tempB = tempB.next;
			countB++;
		}
		int k = Math.abs(countA - countB);
		tempA = headA;
		tempB = headB;
		if (countA >= countB) {
			while (k != 0) {
				tempA = tempA.next;
				k--;
			}
		} else {
			while (k != 0) {
				tempB = tempB.next;
				k--;
			}
		}

		while (tempA != null) {
			if (tempA == tempB) {
				return tempA.data;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		return -1;

	}

	void ReversePrint(Node head) {

		if (head == null) {
			return;
		}
		ReversePrint(head.next);
		System.out.println(head.data);
		return;

	}

	int CompareLists(Node headA, Node headB) {

		while (headA != null && headB != null) {
			if (headA.data != headB.data) {
				return 0;
			}
			headA = headA.next;
			headB = headB.next;
		}
		boolean f = headA == null && headB != null;
		boolean g = headB == null && headA != null;

		if (f || g)
			return 0;
		return 1;

	}

	Node MergeLists(Node l1, Node l2) {
		Node p1 = l1;
		Node p2 = l2;

		Node fakeHead = new Node(0);
		Node p = fakeHead;

		while (p1 != null && p2 != null) {
			if (p1.data <= p2.data) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}

			p = p.next;
		}

		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;

		return fakeHead.next;

	}

	int getNodeFromTail(Node head, int n) {

		Node one = head;
		Node two = head;
		while (two != null && n != 0) {
			two = two.next;
			n--;
		}
		while (two.next != null) {
			one = one.next;
			two = two.next;
		}
		return one.data;

	}

	Node RemoveDuplicates(Node head) {
		Node prev = head;
		Node nex = head;
		while (nex != null) {
			if (nex.data == prev.data) {
				nex = nex.next;
				prev.next = null;
			} else {
				prev.next = nex;
				prev = prev.next;
			}
		}
		return head;
	}

}
