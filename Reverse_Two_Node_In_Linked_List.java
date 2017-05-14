package algorithms;

import com.example.test.Reverse_Two_Step_LL.Node;

public class Reverse_Two_Step_LL {
    private static class Node {
        public Integer data;
        public Node    next;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;

        Node nodeTwo = new Node();
        nodeTwo.data = 2;

        Node nodeThree = new Node();
        nodeThree.data = 11;

        Node nodeFour = new Node();
        nodeFour.data = 13;

        Node nodeFive = new Node();
        nodeFive.data = 5;

        Node nodeSix = new Node();
        nodeSix.data = 6;

        head.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
        nodeFive.next = nodeSix;
        nodeSix.next = null;

        print(head);
        System.out.println("");
        doReverse(head);
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // iterative approach
    public static void doReverse(Node head) {
        // block is group of two nodes
        Node blockPrevNode = null;
        Node blockFirstNode = head;
        Node blockSecondNode = head.next;

        if (blockSecondNode == null) {
            print(head);
            return;
        }

        Node blockNextNode = head.next.next;

        boolean done = false;

        while (!done) {
            if (blockFirstNode == null) {
                done = true;
                continue;
            }

            if (blockSecondNode != null) {
                blockFirstNode.next = blockSecondNode.next;
                blockSecondNode.next = blockFirstNode;
            } else {
                done = true;
                continue;
            }

            if (blockPrevNode == null) {
                head = blockSecondNode;
            } else {
                blockPrevNode.next = blockSecondNode;
            }

            blockPrevNode = blockFirstNode;
            blockFirstNode = blockNextNode;

            if (blockNextNode == null) {
                done = true;
                continue;
            } else {
                blockSecondNode = blockNextNode.next;
                if (blockSecondNode == null) {
                    done = true;
                    continue;
                } else {
                    blockNextNode = blockSecondNode.next;
                }
            }
        }

        print(head);
    }
}
