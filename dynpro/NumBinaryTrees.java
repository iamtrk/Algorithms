//Given a post order elements of a tree, Number of possible binary trees are Catalan number.

public class Solution {
    public int numTrees(int A) {
        int[] res = new int[A+1];
        
        res[0] = 1;
        res[1] = 1;
        
        for(int i=2; i<=A; i++) {
            for(int j=0; j<i; j++) {
                res[i] = res[i] + res[j]*res[i-j-1];
            }
        }
        
        return res[A];
    }
}
