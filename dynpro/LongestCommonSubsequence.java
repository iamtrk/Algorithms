public class lcs {
    public static void main(String[] args) {
        System.out.println(lcs("a", "b"));
    }

    public static int lcs(String a, String b) {
      // Initializing a cache to store processed results.
        int[][] lcs = new int[a.length()+1][b.length()+1];

      // M*N complexity.
        for (int i=0; i<a.length(); i++) {
            for (int j=0; j<b.length(); j++) {
              // When the character is same, increase 1 
                if(a.charAt(i)==b.charAt(j)) {
                    lcs[i+1][j+1] = 1+lcs[i][j];
                } else {
                  // else pick the max possible values from the alternatives.
                    lcs[i+1][j+1] = Math.max(lcs[i][j+1], lcs[i+1][j]);
                }
            }
        }

        return lcs[a.length()][b.length()];
    }
}
