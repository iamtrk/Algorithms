public class LongestCommonSubString {
    public static void main(String[] args) {
        String A = "INDIA";
        String B = "SRILANKA";

        int[][] lcs = new int[B.length()+1][A.length()+1];

        for (int i=0; i<A.length()+1; i++) {
            lcs[0][i] = 0;
        }

        for (int i=0; i<B.length()+1; i++) {
            lcs[i][0] = 0;
        }

        int size = Integer.MIN_VALUE;

        for (int i=1; i<B.length()+1; i++) {
            for (int j=1; j<A.length()+1; j++) {

                if(A.charAt(j-1) == B.charAt(i-1)) {
                // If the character is the same, check the longest common substring till the previous point.
                    lcs[i][j] = 1+lcs[i-1][j-1];
                    size = Math.max(lcs[i][j], size);
                } else lcs[i][j] = 0;
            }
        }

        System.out.println(size);

    }

}
