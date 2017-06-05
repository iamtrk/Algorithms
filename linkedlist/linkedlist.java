package com.fit.linkedlist;

import java.util.Random;

/**
 * Created by iamtrk on 18/03/17.
 */
public class linkedlist {
    private Node head;

    public linkedlist() {
        head = null;
    }

    public void add(Node n) {
        if(head == null) {
            head = n;
        } else {
            Node start = head;
            while (start.next!=null) {
                start = start.next;
            }
            start.next = n;
        }
    }

    public void reverse() {
        head = reverse(head);
    }

    private Node reverse(Node node) {

        if(node == null || node.next == null) {
            return node;
        }

        Node rev = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return rev;
    }

    public void iterate() {
        Node start = head;
        while (start!=null) {
            System.out.print(start.value+" ");
            start = start.next;
        }
        System.out.println();
    }

    public void add(int n) {
        add(new Node(n));
    }


    class Node {
        int value;
        Node next;

        public Node(int n) {
            this.value = n;
            next = null;
        }
    }

    public void doReverse() {

    }

    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        Random random = new Random();
        int N = random.nextInt(10);

        for (int i=0; i<N; i++) {
            ll.add(random.nextInt(100));
        }
        ll.iterate();
        ll.reverse();
        ll.iterate();
        ll.iterate();
    }
}
