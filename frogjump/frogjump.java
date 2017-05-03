https://codility.com/programmers/lessons/4-counting_elements/frog_river_one/

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class frogjump {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        
        int n = A.length;
        
        if( n < X)
            return -1;
        
        int[] output = new int[X];
        
        long actualsum = Long.valueOf((X*(X+1))/2);
        
        long currsum = 0;
        
        //[1, 1, 1, 1]
        
        int check = 0;
        
        for(int i=0; i< n; i++)
        {
            if(output[A[i]-1] == 0)
            {
                output[A[i]-1] = 1;
                currsum += A[i];
                
                check++;
                
                if(currsum >= actualsum && (check == output.length))
                    return i;
            }
        }
        
        
        
        return -1;
    }
}
