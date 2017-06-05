//package com.iamtrk.recursion;

/**
 * Created by iamtrk on 03/06/17.
 */
public class generateBinary {
    public static void main(String[] args) {
        generate(new StringBuilder(), 4);
    }

    public static void generate(StringBuilder s, int d) {
        if(s.length() == d) {
            System.out.println(s);
            return;
        }

        generate(s.append("0"), d);
        s.setLength(s.length()-1);
        generate(s.append("1"), d);
        s.setLength(s.length()-1);
    }

}

