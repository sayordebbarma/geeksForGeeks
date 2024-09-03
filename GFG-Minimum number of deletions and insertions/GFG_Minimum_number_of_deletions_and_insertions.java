class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
        int m = str1.length();
        int n = str2.length();
        
        int lcsLength = longestCommonSubsequence(str1, str2, m, n);
        
        int deletions = m - lcsLength;
        int insertions = n - lcsLength;
        
        return deletions + insertions;
    }

    private static int longestCommonSubsequence(String str1, String str2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[m][n];
	} 
}
