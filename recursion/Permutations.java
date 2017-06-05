//package com.iamtrk.recursion;

/**
 * Created by iamtrk on 03/06/17.
 */
public class permutations {
    public static String s = "123456";
    public static boolean[] used = new boolean[s.length()];
    public static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) {
        permut();
    }

    public static void permut() {

        if(s.length() == builder.length()) {
            System.out.println(builder);
        }

        for (int i=0; i<s.length(); i++) {
            if(used[i]) {
                continue;
            }
            builder.append(s.charAt(i));
            used[i] = true;
            permut();
            used[i] = false;
            builder.setLength(builder.length()-1);
        }

    }
}
