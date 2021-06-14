package com.company;

// a binary tree each has 2 children
public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(Object rootData){
        root = new Node();
        root.data = rootData;
        root.left = null;
        root.right = null;
    }

    public BinaryTree(Object rootData, BinaryTree left, BinaryTree right) {
        root = new Node();
        root.data = rootData;
        root.left = left.root;
        root.right = right.root;
    }

    // returns the height of the tree from the root
    public int height() {
        return height(root);
    }

    // returns the height of the tree from the given subtree
    public static int height(Node n){
        if(n == null) {
            return 0;
        } else {
            return 1 + Math.max(height(n.left), height(n.right));
        }
    }

    // checks if it is empty
    public boolean isEmpty(){
        return root == null;
    }

    // gets the data from the root
    public Object data() {
        return root.data;
    }

    // return the left child of the Root
    public BinaryTree left(){
        BinaryTree result = new BinaryTree();
        result.root = root.left;
        return result;
    }

    // return the right child of the Root
    public BinaryTree right(){
        BinaryTree result = new BinaryTree();
        result.root = root.right;
        return result;
    }

    class Node {
        Object data;
        Node left;
        Node right;
    }
}
