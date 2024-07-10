class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        // code here
        int[] dp = new int[m];
        int maxsize = 0, prev = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int temp = dp[j];
                
                if (i == 0 || j == 0) dp[j] = mat[i][j];
                else if (mat[i][j] == 1) dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), prev) + 1;
                else dp[j] = 0;
                
                maxsize = Math.max(maxsize, dp[j]);
                prev = temp;
            }
        }
        
        return maxsize;
    }
}
