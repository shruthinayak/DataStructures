package com.practice.sort;

import java.util.Scanner;

public class HeapSort {
	int[] pq;
	int size;

	public static void main(String[] args) {
		int[] a = new int[] { 99, 68, 94, 47, 52, 23, 64, 87, 97, 12, 93, 99,
				52, 32, 44, 34, 53, 58, 95, 70 };
		HeapSort heap = new HeapSort(a);
		heap.print();
		int n = 0;
		Scanner read = new Scanner(System.in);
		while (n != 4) {
			System.out.println("Enter a number to insert: ");
			int number = read.nextInt();
			heap.add(number);
			heap.print();
			System.out.println("The number deleted is: " + heap.remove());
			heap.print();
			n++;
		}
		read.close();
		System.out.println("-EOP-");
	}

	HeapSort(int n) {
		pq = new int[n];
	}

	public HeapSort(int[] q) {
		pq = q;
		buildHeap();
	}

	void buildHeap() {

		for (int i = 1; i < pq.length; i++) {
			size++;
			percolateUp(i);
		}

	}

	void percolateDown(int i) {
		int x = pq[i];
		while (2 * i < size) {
			int lchild = pq[2 * i];
			int rchild = -1;
			if ((2 * i + 1) < size) {
				rchild = pq[2 * i + 1];
			}
			int index;
			if (rchild != -1) {
				index = lchild < rchild ? 2 * i : 2 * i + 1;
			} else {
				index = 2 * i;
			}
			if (x > pq[index]) {
				swap(i, index);
				i = index;
			} else {
				break;
			}

		}
		pq[i] = x;
	}

	protected void swap(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	public void percolateUp(int i) {
		pq[0] = pq[i]; // first copy the element to be percolated into another
						// space thereby making pq[i] as the hole.
		while (pq[i / 2] > pq[0]) { // compare the element to its parent
			swap(i, i / 2);
			i = i / 2;
		}
		pq[i] = pq[0];
	}

	public void print() {
		for (int i = 1; i <= size; i++) {
			System.out.println(pq[i]);
		}
	}

	public void add(int x) {
		if (size == pq.length - 1) {
			resize();
		}
		size++;
		pq[size] = x;
		percolateUp(size);
	}

	public int remove() {
		if (size > 0) {
			int top = pq[1];
			pq[1] = pq[size--];
			percolateDown(1);
			return top;
		}
		return -1;
	}

	public void resize() {
		HeapSort newPq = new HeapSort(size * 2);
		int i = 0;
		for (int element : pq) {
			newPq.pq[i++] = element;
		}
		pq = newPq.pq;
	}

}
