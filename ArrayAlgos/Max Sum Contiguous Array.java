public class Solution {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
	    
	    int sum = 0;
	    int max = 0;
	    int minM = a.get(0);
	    
	    for(int i=0; i<a.size(); i++) {
	        minM = Math.max(minM, a.get(i));
	        sum = sum + a.get(i);
	        
	        max = Math.max(max, sum);
	        
	        if(sum<0) {
	            sum = 0;
	        }
	    }
	    
	 
	 if(max == 0) {
	     return minM;
	 } else return max;
	}
}
