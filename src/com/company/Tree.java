package com.company;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    // empty tree
    public Tree() {
        root = null;
    }

    // a tree with one node and no children
    public Tree(Object rootData) {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<Node>();
    }

    // add a subtree as the last child of the root, een splitsing van de huidige node
    public void addSubtree(Tree subtree) {
        root.children.add(subtree.root);
    }

    public int size() {
        if(root == null){
            return 0;
        } else {
            return root.size();
        }
    }

    public void getNames() {
        List<Object> names = new ArrayList<Object>();
        for(Object name : root.children){
            names.add(name);
        }
        System.out.println(names);
    }



    class Node {
        public Object data;
        public List<Node> children;

        // computes the size of the subtree whose root is this node.
        public int size() {
            int sum = 0;
            for(Node child : children){
                sum += child.size();
            }
            return sum + 1;
        }

        public List<Object> getNames() {
            List<Object> names = new ArrayList<Object>();
            for(Object name : children){
                names.add(name);
            }
            return names;
        }
    }
}
