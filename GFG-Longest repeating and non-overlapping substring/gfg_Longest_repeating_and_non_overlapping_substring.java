class Solution {
    static String longestSubstring(String s, int n) {
        // code here
        int[][] lcs = new int[n + 1][n + 1];
        int index = 0;
        int res_length = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // Check for no overlapping
                if (s.charAt(i - 1) == s.charAt(j - 1) && lcs[i - 1][j - 1] + 1 <= j - i) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;

                    if (lcs[i][j] > res_length) {
                        res_length = lcs[i][j];
                        index = i - 1;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        if (res_length > 0) {
            for (int i = index - res_length + 1; i <= index; i++) {
                res.append(s.charAt(i));
            }
        } else {
            res.append("-1");
        }

        return res.toString();
    }
}
