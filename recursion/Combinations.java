//package com.iamtrk.recursion;

/**
 * Created by m01231 on 03/06/17.
 */
public class combinations {
    static String s = "abc";
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) {
        combine(0);
    }

    public static void combine(int d) {
        for (int i=d; i<s.length(); i++) {
            builder.append(s.charAt(i));
            System.out.println(builder);
            combine(i+1);
            builder.setLength(builder.length()-1);
        }
    }
}

