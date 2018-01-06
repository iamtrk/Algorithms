package com.iamtrk.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 *           6
           /   \
          3      7
        /   \     \
        2   5      9

 [6, 3, 2, 5, 7, 9]
 *
 */
public class PreOrderWORecursion {

    public List<Integer> preorder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if(node == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while (stack.size()>0) {
            node = stack.pop();

            result.add(node.val);

            if(node.right!=null) {
                stack.push(node.right);
            }

            if(node.left!=null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(9);

        e.right = f;
        c.right = e;
        c.left = b;
        b.left = a;
        b.right = d;

        PreOrderWORecursion recursion = new PreOrderWORecursion();
        System.out.println(recursion.preorder(c));

    }
}
