//package com.iamtrk.recursion;

/**
 * Created by m01231 on 05/06/17.
 */
public class telephone {
    static String s = "ABCDEFGHIJKLMNOPRSTUVWXY";
    static String[] strings = s.split("(?<=\\G.{3})");
    static StringBuilder builder = new StringBuilder();
    static int counter = 0;

    static String in = "8662665";

    public static void main(String[] args) {
        generateNumbers(0,0);
        System.out.println(counter);
    }

    static void generateNumbers(int m, int d) {

        if(d == in.length()) {
            System.out.println(builder);
            counter++;
            return;
        }

        for (int i=m; i<in.length(); i++) {
            String pio = getByNum(in.charAt(i)-'0');
            for (int j=0; j<pio.length(); j++) {
                builder.append(pio.charAt(j));
                generateNumbers(i+1, d+1);
                builder.setLength(builder.length()-1);
            }
        }
    }

    static String getByNum(int d) {
        if(d == 0 || d==1 || d>9) return Integer.toString(d);
        return strings[d-2];
    }
 }

