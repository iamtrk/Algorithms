package com.fit.dynpro;

/**
 * Created by m01231 on 19/05/17.
 */
public class RodCutting {
    public static void main(String[] args) {
        int[] cutcost = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        int length = 8;
        System.out.println(prit(cutcost, length));



    }

    public static int prit(int[] cutcost, int length) {

        if(length <= 0) {
            return 0;
        }

        if(length == 1) {
            return cutcost[length];
        }

        if(length == 2) {
            return Math.max(cutcost[length], cutcost[1]*2);
        }

        int d = Integer.MIN_VALUE;
        int l = Math.min(cutcost.length-1, length);

        for (int i=1; i< l; i++) {
            d = Math.max(d, prit(cutcost, length-i) + cutcost[i]);
        }

        if(length <= cutcost.length-1) {
            d = Math.max(cutcost[length], d);
        }

        return d;
    }

}

