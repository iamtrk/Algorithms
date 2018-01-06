package com.iamtrk.trees;

import java.util.*;

/**
 * 
 *          6
         /    \
        3      7
      / \       \
     2   5       9
 * 
 
 [0]
6 

[-1, 1]
3 7 

[1, -2, 0]
7 2 5 

[-2, 0, 2]
2 5 9 

[0, 2]
5 9 

[2]
9 
 */

public class verticalOrder {

    public TreeMap<Integer, ArrayList<Integer>> vo =  new TreeMap<>();


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

        verticalOrder v = new verticalOrder();
        List<List<Integer>> verticalList = v.verticalOrderList(c);

        for (int i=0; i<verticalList.size(); i++) {
            //System.out.println(verticalList.get(i));
        }
    }

    public List<List<Integer>> verticalOrderList(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(root==null) return res;

        Map<Integer, List<Integer>> map = new HashMap<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer>  level = new LinkedList<>();

        queue.offer(root);
        level.offer(0);

        int minLevel = 0;
        int maxLevel = 0;

        while (!queue.isEmpty()) {

            System.out.println(level);
            for (TreeNode aQueue : queue) {
                System.out.print(aQueue.val + " ");
            }
            System.out.println();
            System.out.println();

            TreeNode p = queue.poll();
            int l = level.poll();

            minLevel = Math.min(minLevel, l);
            maxLevel = Math.max(maxLevel, l);

            if(map.containsKey(l)) {
                map.get(l).add(p.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(p.val);
                map.put(l, list);
            }

            if(p.left!=null) {
                queue.offer(p.left);
                level.offer(l-1);
            }

            if(p.right!=null) {
                queue.offer(p.right);
                level.offer(l+1);
            }
        }

        for (int i=minLevel; i<=maxLevel; i++) {
            if(map.containsKey(i)) {
                res.add(map.get(i));
            }
        }

        return res;

    }


}

class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode (int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
