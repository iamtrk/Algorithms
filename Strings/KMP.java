public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        
        if(B == null) return -1;
        
        if(A == null) return -1;
        
        int[] lsp = computeLPSArr(B);

        int j = 0;  // Number of chars matched in pattern
        for (int i = 0; i < A.length(); i++) {
            while (j > 0 && A.charAt(i) != B.charAt(j)) {
                // Fall back in the pattern
                j = lsp[j - 1];  // Strictly decreasing
            }
            if (A.charAt(i) == B.charAt(j)) {
                // Next char matched, increment position
                j++;
                if (j == B.length())
                    return i - (j - 1);
            }
        }
        return -1;  // Not found
    }
    
    public int[] computeLPSArr(String pattern) {
        int[] lsp = new int[pattern.length()];
        lsp[0] = 0;  // Base case
        for (int i = 1; i < pattern.length(); i++) {
            // Start by assuming we're extending the previous LSP
            int j = lsp[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = lsp[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j))
                j++;
            lsp[i] = j;
        }
        return lsp;
    }
    
    
}
