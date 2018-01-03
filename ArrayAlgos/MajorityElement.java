public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        int c = 0;
        int m = A.get(0);
        for(int i=0; i<A.size(); i++) {
            if(c == 0) {
                c=1;
                m = A.get(i);
            } else if(m == A.get(i)) {
                c++;
            } else {
                c--;
            }
        }
        
        return m;
    }
}
