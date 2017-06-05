//package com.iamtrk.recursion;

/**
 * Created by m01231 on 05/06/17.
 */
public class SumFormation {
    public static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) {
        numways(12);
    }

    public static void numways(int d) {

        if(d == 0) {
            System.out.println(builder);
            return;
        }

        for (int i=1; i<=d; i++) {
            builder.append(" "+i);
            int l = (" "+i).length();
            numways(d-i);
            builder.setLength(builder.length()-l);
        }

    }
}

