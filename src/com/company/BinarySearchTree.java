package com.company;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // inserts a new node into the tree
    public void add(Comparable obj) {
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;
        if (root == null) {
            root = newNode;
        } else {
            root.addNode(newNode);
        }
    }

    // tries to find an object in the tree
    public boolean find(Comparable obj) {
        Node current = root;
        while (current != null) {
            int d = current.data.compareTo(obj);
            if (d == 0) {
                return true;
            } else if (d > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    // tries to remove an object from the tree. Does nothing if the object is not in the tree
    public void remove(Comparable obj) {
        // Find the node to be removed
        Node toBeRemoved = root;
        Node parent = null;
        boolean found = false;
        while (!found && toBeRemoved != null) {
            int d = toBeRemoved.data.compareTo(obj);
            if (d == 0) {
                found = true;
            } else {
                parent = toBeRemoved;
                if (d > 0) {
                    toBeRemoved = toBeRemoved.left;
                } else {
                    toBeRemoved = toBeRemoved.right;
                }
            }

            if (!found) {
                return;
            }

            // toBeRemoved contains obj
            // if one of the children is empty, use the other

            if (toBeRemoved.left == null || toBeRemoved.right == null) {
                Node newChild;
                if (toBeRemoved.left == null) {
                    newChild = toBeRemoved.right;
                } else {
                    newChild = toBeRemoved.left;
                }

                // Found in root
                if (parent == null) {
                    root = newChild;
                } else if (parent.left == toBeRemoved) {
                    parent.left = newChild;
                } else {
                    parent.right = newChild;
                }
                return;
            }

            // Neither subtree is empty
            // Find smallest element of the right subtree

            Node smallestParent = toBeRemoved;
            Node smallest = toBeRemoved.right;
            while (smallest.left != null){
                smallestParent = smallest;
                smallest = smallest.left;
            }

            // smallest contains smallest child in the right subtree
            // Move contents, unlink child

            toBeRemoved.data = smallest.data;
            if(smallestParent == toBeRemoved){
                smallestParent.right = smallest.right;
            } else {
                smallestParent.left = smallest.right;
            }
        }
    }

    public void print() {
        print(root);
        System.out.println();
    }

//    // In order print
//    public void print(Node parent){
//        if (parent == null){
//            return;
//        }
//
//        print(parent.left);
//        System.out.println(parent.data + " ");
//        print(parent.right);
//    }

//    // Pre order print
//    public void print(Node parent){
//        if (parent == null){
//            return;
//        }
//
//        System.out.println(parent.data + " ");
//        print(parent.left);
//        print(parent.right);
//    }

    // Post order print
    public void print(Node parent){
        if (parent == null){
            return;
        }

        print(parent.left);
        print(parent.right);
        System.out.println(parent.data + " ");
    }


    class Node {
        public Comparable data;
        public Node left;
        public Node right;

        // adds a descendant to this node
        public void addNode(Node newNode) {
            int comp = newNode.data.compareTo(data);
            if (comp < 0) {
                if (left == null) {
                    left = newNode;
                } else {
                    left.addNode(newNode);
                }
            } else if (comp > 0) {
                if (right == null) {
                    right = newNode;
                } else {
                    right.addNode(newNode);
                }
            }
        }
    }
}

