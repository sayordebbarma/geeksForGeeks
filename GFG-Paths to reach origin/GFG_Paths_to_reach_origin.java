class Solution
{
    static final int MOD = 1000000007;
    
    public static int ways(int n, int m)
    {
        // complete the function
        int[][] dp = new int[n + 1][m + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}
