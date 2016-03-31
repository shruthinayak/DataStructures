package com.practice.sort;


import java.util.Scanner;

class Student {
	private int token;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.token = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getToken() {
		return token;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}

    public void print(){
        System.out.println(fname);
    }
	public int equals(Student s) {
		if (s.cgpa < this.cgpa)
			return 1;
		else if (s.cgpa > this.cgpa)
			return -1;
		else if (this.fname.compareTo(s.fname) == 1) {
			return 1;
		} else if (this.fname.compareTo(s.fname) == -1)
			return -1;
		else if (this.token < s.token) {
			return 1;
		} else
			return -1;
	}
}

public class Solution {
	Student[] pq;
	int size;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int totalEvents = Integer.parseInt(in.nextLine());
		Solution s = new Solution(5);
        while (totalEvents > 0) {
			String event = in.nextLine();
            //ENTER Maria 3.6 46
            System.out.println(event);
            String[] a = event.split(" ");
            if(a[0].equals("ENTER")){
                //System.out.println(a[1]+":"+ Double.parseDouble(a[2]));
                s.add(new Student(totalEvents, a[1], Double.parseDouble(a[2])));
            } else{
                s.remove();
            }
            
			// Complete your code
            while(s.size!=0){
                s.remove().print();
            }
			totalEvents--;
		}
        
	}
Solution(int n) {
		pq = new Student[n];
	}
	public Solution(Student[] q) {
		pq = q;
		buildHeap();
	}

	void buildHeap() {

		size = pq.length / 2;
		for (int i = pq.length / 2 - 1; i >= 1; i--) {
			size++;
			percolateDown(i);
		}
	}

	void percolateDown(int i) {

		Student x = pq[i];
		while (2 * i < size) {
			Student lchild = pq[2 * i];
			Student rchild = null;
			if ((2 * i + 1) < size) {
				rchild = pq[2 * i + 1];
			}
			int index;
			if (rchild != null) {
				index = lchild.equals(rchild) > 0 ? 2 * i : 2 * i + 1;
			} else {
				index = 2 * i;
			}
			if (x.equals(pq[index]) < 0) {
				swap(i, index);
				i = index;
			} else {
				break;
			}

		}
		pq[i] = x;
	}

	protected void swap(int i, int j) {
		Student temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
    
    public void add(Student x) {
		if (size == pq.length - 1) {
			resize();
		}
		size++;
		pq[size] = x;
		percolateUp(size);
	}

	public Student remove() {
		if (size > 0) {
			Student top = pq[1];
			pq[1] = pq[size--];
			percolateDown(1);
			return top;
		}
		return null;
	}

	public void resize() {
		Solution newPq = new Solution(size * 2);
		int i = 0;
		for (Student element : pq) {
			newPq.pq[i++] = element;
		}
		pq = newPq.pq;
	}
	public void percolateUp(int i) {
		pq[0] = pq[i]; // first copy the element to be percolated into another
						// space thereby making pq[i] as the hole.
		while (pq[i / 2].equals(pq[0])==1) { // compare the element to its parent
			swap(i, i / 2);
			i = i / 2;
		}
		pq[i] = pq[0];
	}

}
