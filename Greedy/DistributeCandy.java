public class Solution {
    public int candy(ArrayList<Integer> A) {
        if(A==null || A.size()==0) return 0;
        
        int[] candies = new int[A.size()];
        candies[0] = 1;
        
        for(int i=1; i<A.size(); i++) {
            if(A.get(i)>A.get(i-1)) {
                candies[i] = candies[i-1]+1;
            } else candies[i] = 1;
        }
        
        int result = candies[candies.length-1];
        
        for(int i=candies.length-2; i>=0; i--) {
            int cur = 1;
            
            if(A.get(i)>A.get(i+1)) {
                cur = candies[i+1]+1;
            }
            
            result += Math.max(cur, candies[i]);
            candies[i]=cur;
        }
        
        return result;
        
    }
}
