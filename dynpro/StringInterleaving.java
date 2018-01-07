public class stringInterleaving {
    public static void main(String[] args) {
        String a = "imt";

        String b = "akr";

        String c = "iamtrk";


        boolean[][] intr = new boolean[a.length()+1][b.length()+1];
        intr[0][0] = true;

        for (int i=1; i<a.length()+1; i++) {
            if(a.charAt(i-1) == c.charAt(i-1)) {
                intr[i][0] = intr[i-1][0];
            }
        }

        for(int j=1; j<b.length()+1; j++) {
            if(b.charAt(j-1) == c.charAt(j-1)) {
                intr[0][j] = intr[0][j-1];
            }
        }

        for (int i=1; i<a.length()+1; i++) {
            for (int j=1; j<b.length()+1; j++) {
                if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) != c.charAt(i+j-1)) {
                    intr[i][j] = intr[i-1][j];
                } else if(a.charAt(i-1) != c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)) {
                    intr[i][j] = intr[i][j-1];
                } else if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1)) {
                    intr[i][j] = intr[i][j-1] || intr[i-1][j];
                } else intr[i][j] = false;
            }
        }

        System.out.println(intr[a.length()][b.length()]);
    }
}
