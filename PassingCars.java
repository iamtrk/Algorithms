//https://codility.com/programmers/lessons/5-prefix_sums/passing_cars/
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        int zeroscount = 0;
        
        boolean flag = false;
        
        int num = 0;
        
        Long totalcount = 0L;
        
        for(int i=0; i< A.length; i++)
        {
            num = A[i];
            
            if(num == 0)
            {
                flag = true;
                zeroscount++;
            }
            else //num is 1
            {
             
                if(flag)
                {
                    //increment totalcount zeroscount times
                    
                    totalcount = totalcount+zeroscount;
                    
                    //for(int j=0; j<zeroscount;j++)
                     //   totalcount++;
                }
                
                
            }
        }
        if(totalcount > 1000000000)
            return -1;
        else
            return totalcount.intValue();
    }
}
