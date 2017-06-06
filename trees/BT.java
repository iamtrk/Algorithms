package com.iamtrk.trees;

import java.util.Random;

/**
 * Created by m01231 on 05/06/17.
 */
public class BT {

    public static void main(String[] args) {
        BT bt = new BT();
        Random random = new Random();

        int N = random.nextInt(100);

        for (int i=0; i<N; i++) {
            bt.add(5);
        }

        bt.inorder();
    }

    node root;

    public BT(node root) {
        this.root = root;
    }

    public BT() {}

    public void add(int x) {
        add(new node(x));
    }
    private void add(node x) {
        if(root == null) {
            root = x;
            return;
        }

        node n = root;

        while (true) {
            if(x.value < n.value) {
                if(n.left != null) {
                    n = n.left;
                } else {
                    n.left = x;
                    break;
                }
            } else if(x.value > n.value) {
                if(n.right!=null) {
                    n = n.right;
                } else {
                    n.right = x;
                    break;
                }
            } else {
                n.value = x.value;
                break;
            }
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(node x) {
        if (x!=null) {
            inorder(x.left);
            System.out.println(x.value);
            inorder(x.right);
        }
    }
}

class node {
    int value;

    node left, right;

    public node(int value) {
        this.value = value;
    }
}

