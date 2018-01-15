public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int trap(final List<Integer> A) {
        int result=0;
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];
        
        left[0] = A.get(0);
        int max = A.get(0);
        
        for(int i=1; i<A.size(); i++) {
            if(A.get(i)>max) max=A.get(i);
            left[i] = max;
        }
        
        right[A.size()-1] = A.get(A.size()-1);
        max = A.get(A.size()-1);
        
        for(int j=A.size()-1; j>=0; j--) {
            if(A.get(j)>max) max=A.get(j);
            right[j] = max;
        }
        
        for(int i=0; i<A.size(); i++) {
            result += Math.min(left[i],right[i])-A.get(i);
        }
        
        return result;
    }
}
