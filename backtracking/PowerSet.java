public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        int n = A.size();
        
        // Run a loop for printing all 2^n
        // subsets one by one
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<(1<<n); i++) {
            ArrayList<Integer> pe = new ArrayList<>();
            
            // Print current subset
            for(int j=0; j<n; j++) {
                
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                
                if((i & (1<<j)) > 0) {
                    pe.add(A.get(j));
                }
            }
            res.add(pe);
        }
        
        return res;
    }
}
