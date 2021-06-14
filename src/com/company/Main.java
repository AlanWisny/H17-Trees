package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Tree t1 = new Tree("Anne");
        Tree t2 = new Tree("Peter");
        t1.addSubtree(t2);

        Tree t3 = new Tree("Zara");
        t1.addSubtree(t3);

        Tree t4 = new Tree("Savannah");
        t2.addSubtree(t4);

        System.out.println("Size: " + t1.size());

        BinaryTree questionTree = new BinaryTree("Is it a mammal?",
                new BinaryTree("Does it have stripes?",
                        new BinaryTree("Is it a carnivore?",
                                new BinaryTree("It is a tiger"),
                                new BinaryTree("It is a zebra.")),
                        new BinaryTree("It is a pig.")),
                new BinaryTree("Does it fly?",
                        new BinaryTree("It is an eagle."),
                        new BinaryTree("Does it swim?",
                                new BinaryTree("It is a penguin."),
                                new BinaryTree("It is an ostrich."))));


//        BinaryTree tree = new BinaryTree(null, "");
        questionTree.height();
        Boolean done = false;
        Scanner in = new Scanner(System.in);
        while(!done){
            BinaryTree left = questionTree.left();
            BinaryTree right = questionTree.right();
            if (left.isEmpty() && right.isEmpty()) {
                System.out.println(questionTree.data());
                done = true;
            } else {
                String response;
                do {
                    System.out.println(questionTree.data() + "(Y/N) ");
                    response = in.next().toUpperCase();
                } while (!response.equals("Y") && !response.equals("N"));

                if (response.equals("Y")) {
                    questionTree = left;
                } else {
                    questionTree = right;
                }
            }
        }


        BinarySearchTree t = new BinarySearchTree();
        t.add("D");
        t.add("B");
        t.add("A");
        t.add("C");
        t.add("F");
        t.add("E");
        t.add("I");
        t.add("G");
        t.add("H");
        t.add("J");
//        t.remove("A");
//        t.remove("B");
//        t.remove("F");
//        t.remove("D");
        //t.print();
        System.out.println("Expected: C E G H I J");


    }
}
