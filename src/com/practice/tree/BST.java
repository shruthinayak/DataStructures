package com.practice.tree;

import java.util.Stack;

public class BST {

    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;
        for (int i = 90; i > 50; i -= 3)
            root = tree.insert(root, i);
        System.out.println("Inorder traversal of the tree after insertion.");
        tree.inorder(root);
        System.out.println("Deleting 72...");
        root = tree.delete(root, 72);
        System.out.println("Deleting 57...");
        root = tree.delete(root, 57);

        System.out.println("Inorder traversal of the tree after deletion.");
        tree.inorder(root);
        System.out.println("Preoder traversal of a tree");
        tree.iterativePreOrder(root);
    }

    private Node delete(Node root, int toDelete) {
        if (root == null) {
            System.out.println("Cannot delete. Tree is empty");
            return root;
        } else if (toDelete < root.data)
            root.left = delete(root.left, toDelete);
        else if (toDelete > root.data)
            root.right = delete(root.right, toDelete);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                root.data = root.left.data;
                root.left = delete(root.left, root.data);
            }
        }
        return root;
    }

    Node insert(Node root, int value) {
        Node n = new Node();
        n.data = value;
        if (root == null) {
            return n;
        }
        if (value > root.data) {
            if (root.right == null) {
                root.right = n;
            } else {
                insert(root.right, value);
            }
        }

        if (value < root.data) {
            if (root.left == null) {
                root.left = n;
            } else {
                insert(root.left, value);
            }
        }
        return root;
    }

    void inorder(Node root) {
        if (root.left != null) {
            inorder(root.left);
        }
        System.out.print(root.data + ", ");
        if (root.right != null) {
            inorder(root.right);
        }
    }

    public class Node {
        Node left = null;
        Node right = null;
        boolean visited;
        int data;

        public Node(int d) {
            this.data = d;
        }

        public Node() {

        }

        void print() {
            System.out.print(data + ":" + left != null ? left.data : "" + ", " + right != null ? right.data : ""+"; ");
        }
    }

    void iterativePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println();
        Stack<Node> s = new Stack<>();
        s.push(root);
        System.out.println(root.data);
        while (!s.isEmpty()) {
            Node top = s.peek();
            if (!top.visited) {

                System.out.print(top.data+", ");
                top.visited = true;
            }
            if (top.left != null && !top.left.visited) {
                s.push(top.left);
            } else if (top.right != null && !top.right.visited) {
                s.push(top.right);
            } else {
                s.pop();
            }
        }
    }

}
