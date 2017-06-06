package com.iamtrk.trees;

import java.util.*;

/**
 * Created by m01231 on 06/06/17.
 */
public class treealgos {
    BT bt;
    public treealgos(BT bt) {
        this.bt = bt;
    }

    public static void main(String[] args) {
        BT bt = new BT();
        Random random = new Random();

        int N = random.nextInt(10)+1;

        for (int i=0; i<N; i++) {
            int d = random.nextInt(200);
            bt.add(d);
        }
        bt.inorder();
        treealgos al = new treealgos(bt);
        System.out.println("Done");
        List<List<Integer>> lists = al.bfslists();

        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    /*
    * Returns the list of values present at each level
    * as list of lists.
    * */
    public List<List<Integer>> bfslists() {
        List<List<Integer>> lists = new ArrayList<>();

        Queue<node> one = new LinkedList<>();
        one.add(bt.getRoot());

        while (!one.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int N = one.size();
            for (int i=0; i<N; i++) {
                node p = one.poll();
                list.add(p.value);

                if(p.left!=null) {
                    one.add(p.left);
                }

                if(p.right!=null) {
                    one.add(p.right);
                }
            }
            lists.add(list);
        }

        return lists;
    }
}

