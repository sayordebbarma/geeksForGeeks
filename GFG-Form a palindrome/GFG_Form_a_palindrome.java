class Solution{
    static int countMin(String str)
    {
        // code here
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int gap = 1; gap < n; gap++) {
            for (int l = 0, h = gap; h < n; l++, h++) {
                dp[l][h] = (str.charAt(l) == str.charAt(h)) ? 
                            dp[l + 1][h - 1] : 
                            (Math.min(dp[l][h - 1], dp[l + 1][h]) + 1);
            }
        }

        return dp[0][n - 1];
    }
}
