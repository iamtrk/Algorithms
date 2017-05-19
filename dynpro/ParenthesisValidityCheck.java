package com.fit.dynpro;

/**
 * Created by m01231 on 19/05/17.
 *
 *  => Have two two counters 1 for open parentheses & 1 for closed parentheses.
    => Read one character at a tine & increment the corresponding counter.
    => If at any point, if count of close parentheses is > than open parentheses return false Ex: {{}}}{
    => If at the end both are equal, return true.
 *
 *
 */
public class ParenthesisValidityCheck {
    public static void main(String[] args) {
        System.out.println(checkValidParanthesis("(()())("));
    }

    public static boolean checkValidParanthesis(String paren) {
        int closed = 0;
        int open   = 0;

        for (int i=0; i<paren.length(); i++) {
            if(paren.charAt(i) == '(') {
                open = open+1;
            } else if(paren.charAt(i) == ')') {
                closed = closed+1;
            }

            if(closed > open) {
                return false;
            }
        }

        return open == closed;
    }
}

