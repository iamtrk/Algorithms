import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static long[][] sol;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        sol = new long[n+1][coins.length];
        System.out.println(total(n, coins, coins.length-1));
    }
    
    public static long total(int n, int[] v, int i) {
        if(n==0) return 1;

        if(n<0) {
            return 0;
        }

        if(i==-1 && n>0) {
            return 0;
        }

        if(sol[n][i]!=0) {
            return sol[n][i];
        }

        sol[n][i] = total(n, v, i-1)+total(n-v[i],v, i);

        return sol[n][i];

    }
}
