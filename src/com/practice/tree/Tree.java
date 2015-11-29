package com.practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.practice.graphs.GraphNode;

//Insertion
//Deletion
//Searching
//kth smallest/greatest element
//range of numbers in a BST
//Given 2 arrays, check if they make the same BST
//Largest BST in a Tree
//DLL for a tree
//http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
// Floor and Ceil from a BST
//Find a pair with given sum in a Balanced BST
public class Tree {

	private static boolean found = false;
	private static int k = 3;

	public static void main(String[] args) {
		int[] a = { 20, 30, 40, 50, 10, 70, 80 };
		Arrays.sort(a);
		Node root = constructionNormal(a, 0, a.length);
	}

	public static int maxPathSum(Node head, int max) {
		if (head.left == null) {
			return 0;
		}
		if (head.right == null) {
			return 0;
		}
		int rightSum = maxPathSum(head.left, max);
		int leftSum = maxPathSum(head.right, max);
		int sum = Math.max(head.data + Math.max(rightSum, leftSum), head.data);
		int maxtop = Math.max(sum, rightSum + leftSum + head.data);
		max = Math.max(max, maxtop);
		return sum;
	}

	public static boolean isABST(Node root) {
		if (root.left != null) {
			if (root.left.data > root.data)
				return false;
			else
				isABST(root.left);
		}
		if (root.right != null) {
			if (root.right.data < root.data)
				return false;
			else
				isABST(root.right);
		}
		return true;
	}

	public static int heightOfBinaryTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			int a = heightOfBinaryTree(root.left);
			int b = heightOfBinaryTree(root.right);
			return 1 + (Math.max(a, b));
		}
	}

	public static void kthGreatestOrSmallest(boolean small, Node root) {

		if (small) {
			if (root.left != null) {
				kthGreatestOrSmallest(true, root.left);
			}
			k = k - 1;
			if (k == 0) {
				System.out.println(root.data);
			}
			if (root.right != null) {
				kthGreatestOrSmallest(true, root.right);
			}
		} else {
			if (root.right != null) {
				kthGreatestOrSmallest(true, root.right);
			}
			k = k - 1;
			if (k == 0) {
				System.out.println(root.data);
			}
			if (root.left != null) {
				kthGreatestOrSmallest(true, root.left);
			}

		}

	}

	public static void inorder(Node root) {
		if (root.left != null) {
			inorder(root.left);
		}
		System.out.println(root.data);
		if (root.right != null) {
			inorder(root.right);
		}
	}

	public static void preorder(Node root) {
		System.out.println(root.data);
		if (root.left != null) {
			preorder(root.left);
		}
		if (root.right != null) {
			preorder(root.right);
		}
	}

	public static void postorder(Node root) {
		if (root.left != null) {
			postorder(root.left);
		}
		if (root.right != null) {
			postorder(root.right);
		}
		System.out.println(root.data);
	}

	public static GraphNode construction(int[] a, int start, int end) {

		int mid = (start + end) / 2;
		GraphNode root = null;
		if (start >= end) {
			return null;
		}
		root = new GraphNode(a[mid]);
		root.connect(construction(a, start, mid));
		root.connect(construction(a, mid + 1, end));
		return root;
	}

	public static Node constructionNormal(int[] a, int start, int end) {
		int mid = (start + end) / 2;
		Node root = null;
		if (start >= end) {
			return null;
		}
		root = new Node(a[mid]);
		root.left = constructionNormal(a, start, mid);
		root.right = constructionNormal(a, mid + 1, end);
		return root;
	}

	public static int greatestSum(Node root) {
		if (root.right != null) {
			root.data = root.data + greatestSum(root.right);
			return root.data;
		}
		if (root.left != null) {
			root.data = root.data + greatestSum(root.left);
			return root.data;
		}
		return root.data;
	}

	// Common ancestor - first node that is greater than first ele and second
	// node less than or equal to second ele.
	static Node lca(Node root,int v1,int v2)
    {
        if(v1>v2){
            int temp = v2;
            v2 = v1;
            v1 = temp;
        }
        if(root.data>= v1 && root.data<= v2){
            
            return root;
        }
        if(root.left!=null){
            return lca(root.left, v1, v2);
        } else if(root.right!=null){
            return lca(root.right, v1, v2);
        }
       return null;
    }

	void levelOrder(Node root) {
		List<Node> queue = new ArrayList<Node>();
		queue.add(root);
		while (queue.size() != 0) {
			Node now = queue.get(0);
			queue.remove(0);
			System.out.print(now.data + " ");
			if (now.left != null)
				queue.add(now.left);
			if (now.right != null)
				queue.add(now.right);
		}

	}

	static Node Insert(Node root, int value) {
		Node n = new Node();
		n.data = value;
		if (root == null) {
			return n;
		}
		if (value > root.data) {
			if (root.right == null) {
				root.right = n;
			} else {
				Insert(root.right, value);
			}
		}

		if (value < root.data) {
			if (root.left == null) {
				root.left = n;
			} else {
				Insert(root.left, value);
			}
		}
		return root;
	}
}
