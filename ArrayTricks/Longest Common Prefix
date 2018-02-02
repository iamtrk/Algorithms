public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        
        int min = A.get(0).length();

        for (int i=1; i<A.size(); i++) {
            min = Math.min(min, A.get(i).length());
        }

        int i=0;

        while (i<min) {

            String l = A.get(0);
            boolean same = true;
            for (int j=1; j<A.size(); j++) {
                same = same&&(l.charAt(i)==A.get(j).charAt(i));
            }
            if(!same) break;
            i++;
        }

        return A.get(0).substring(0,i);
        
    }
}
