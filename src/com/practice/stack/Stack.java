/*
package com.practice.stack;


import com.practice.list.Node;

public class Stack {
	Node top = null;
	
	void push(int d){
		Node n = new Node(d);
		n.next=top;
		top=n;
	}
	void pop(){
		System.out.println("Popped item is "+top.data);
		if(top.next!=null)
			top=top.next;
		else top = null;
	}
	void printStack(){
		Node pointer = top;
		while(pointer!=null){
			System.out.print(pointer.data+"->");
			pointer=pointer.next;
		}
	}
}
*/
