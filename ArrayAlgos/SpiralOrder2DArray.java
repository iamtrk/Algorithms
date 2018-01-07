public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int m = A.size(); // No. of rows.
        int n = A.get(0).size(); // No. of columns.
        
        int i=0, k=0, l=0;
        // k is starting row & l is starting column.
        ArrayList<Integer> result = new ArrayList<>();
        
        while(k<m && l<n) {
            // get top row (L to R - excluding the last element.)
            for(i=l; i<n; ++i) {
                result.add(A.get(k).get(i));
            }
            k++;
            // get the right most column. (Top to bottom - excluding the last element.)
            for(i=k; i<m; ++i) {
                result.add(A.get(i).get(n-1));
            }
            n--;
            
            if(k<m) {
             // Get the bottom row from R to L - excluding the last element.
                for(i=n-1; i>=l; --i) {
                    result.add(A.get(m-1).get(i));
                }
                m--;
            }
            
            if(l<n) {
            // Get the right most column from bottom up - excluding the last element.
                for(i=m-1; i>=k; --i) {
                    result.add(A.get(i).get(l));
                }
                l++;
            }
        }
        
        return result;
    }
}
