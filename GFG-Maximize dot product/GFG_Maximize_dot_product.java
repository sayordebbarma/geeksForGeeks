class Solution
{
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return calculateMaxDotProduct(0, 0, n, m, a, b, dp, n - m);
    }

    private int calculateMaxDotProduct(int i, int j, int n, int m, int[] a, int[] b, int[][] dp, int diff) {
        if (i == n || j == m) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int sum1 = (diff != 0) ? calculateMaxDotProduct(i + 1, j, n, m, a, b, dp, diff - 1) : 0;
        int sum2 = a[i] * b[j] + calculateMaxDotProduct(i + 1, j + 1, n, m, a, b, dp, diff);
        return dp[i][j] = Math.max(sum1, sum2);
	} 
}
