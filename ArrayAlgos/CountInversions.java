import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        
    }
   
    public static long countInversions(int[] arr) {
        // Split the array into mid.
        if(arr.length < 2) return 0;
        int m = (arr.length+1)/2;
        // Make two arrays.
        int[] leftr = Arrays.copyOfRange(arr, 0, m);
        int[] riter = Arrays.copyOfRange(arr, m, arr.length);
        // Run count inversions seperately on each half.
        long a = countInversions(leftr);
        long b = countInversions(riter);
        
        return a + merge(arr, leftr, riter) + b;
        
    }
    
    public static long merge(int[] arr, int[] leftr, int[] riter) {
        int i=0, j=0;
        long count=0L;
        
        while(i<leftr.length || j<riter.length) {
            if(i==leftr.length) {
                arr[i+j] = riter[j];
                j++;
            } else if(j==riter.length) {
                arr[i+j] = leftr[i];      
                i++;
            } else if(leftr[i]<=riter[j]) {
                arr[i+j] = leftr[i];
                i++;
            } else {
            
                arr[i+j] = riter[j];
                // Here, if the index at 0 is >riter[j] then total length of the array should be added.
                count = count + leftr.length-i;
                j++;
            }
        }
        
        return count;
        
    }
}
