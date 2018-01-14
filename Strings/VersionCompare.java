public class Solution {
    public int compareVersion(String A, String B) {
        String[] v1 = A.split("\\.");
        String[] v2 = B.split("\\.");

        int i=0;
        
        while(i<v1.length || i<v2.length) {
            
            if(i<v1.length && i<v2.length) {
                if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                } else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    return 1;
                }
            } else if(i<v1.length) {
                if(Integer.parseInt(v1[i])!=0)
                    return 1;
            } else if(i<v2.length) {
                if(Integer.parseInt(v2[i])!=0)
                return -1;
            }
            i++;
        }
        return 0;
        
    }
}
