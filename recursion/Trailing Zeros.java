public class Solution {
    public int trailingZeroes(int A) {
        
        int c = 0;
        int i=1;
        int x = (int) Math.pow((int)5, i);
        while(A>=x) {
            c = c + (A/x);
            x = (int)Math.pow((int)5, ++i);
        }
        
        return c;
        
    }
}
