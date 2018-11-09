package com.iamtrk.stuff;

import java.util.HashSet;

public class prg {

    public static void main(String[] args) {

        Node a = new Node(10);
        a.left = new Node(5);
        a.right = new Node(15);
        a.left.left = new Node(1);
        a.left.right = new Node(3);
        a.right.left = new Node(13);
        a.right.right = new Node(18);

        System.out.println(sumtwo(a, new HashSet<Integer>(), 19));
    }

    static boolean sumtwo(Node n, HashSet<Integer> integers, int sum) {
        if(n==null) return false;

        if(sumtwo(n.left, integers, sum)){
            return true;
        }

        if(integers.contains(sum-n.data)) {
            System.out.println("contains: "+ integers);
            return true;
        } else {
            integers.add(n.data);
        }

        return sumtwo(n.right, integers, sum);
    }
}

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
