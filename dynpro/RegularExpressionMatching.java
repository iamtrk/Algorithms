public class regExMatching {
    public static void main(String[] args) {

        System.out.println(isMatch("abbbc", "ab*"));

    }


    public static boolean isMatch(String s, String p) {

        int len1 = s.length();
        int len2 = p.length();

        boolean[][] match = new boolean[len1 + 1][len2 + 1];
        match[0][0] = true;
        for (int i = 0; i < len2; i++) {
            if (p.charAt(i) == '*' && match[0][i - 1]) {
                match[0][i + 1] = true;
            }
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // p[j] is '.'.
                if (p.charAt(j) == '.') {
                    match[i + 1][j + 1] = match[i][j];
                }

                // P[j] is a regular char.
                if (p.charAt(j) == s.charAt(i)) {
                    match[i + 1][j + 1] = match[i][j];
                }

                if (p.charAt(j) == '*') {
                    // preceding char does not match, count as empty.
                    if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) {
                        match[i + 1][j + 1] = match[i + 1][j - 1];
                    } else {
                        // match[i + 1][j]: match one char.
                        // match[i][j + 1]: match multiple char.
                        // match[i + 1][j - 1]: match empty char.
                        match[i + 1][j + 1] = match[i + 1][j] || match[i][j + 1] || match[i + 1][j - 1];
                    }
                }
            }
        }
        return match[len1][len2];
    }
}
