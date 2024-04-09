class Solution {
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return calculatePoints(0, 0, m, n, points, dp);
    }

    private int calculatePoints(int i, int j, int m, int n, int[][] points, int[][] dp) {
        if (i == m - 1 && j == n - 1) return 1 - points[i][j];
        if (i == m || j == n) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        int right = calculatePoints(i, j + 1, m, n, points, dp);
        int down = calculatePoints(i + 1, j, m, n, points, dp);
        dp[i][j] = Math.max(1, Math.min(right, down) - points[i][j]);
        return dp[i][j];
    }
}
