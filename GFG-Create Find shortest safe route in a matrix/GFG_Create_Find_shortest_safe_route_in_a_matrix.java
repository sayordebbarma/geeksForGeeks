class Solution {
    private static final int MAX_VALUE = 1000000000;

    public int findShortestPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];

        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        int min = MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, rec(i, 0, mat, vis, dp));
        }
        return min == MAX_VALUE ? -1 : min;
    }

    private int rec(int i, int j, int[][] mat, boolean[][] vis, int[][] dp) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || vis[i][j] || mat[i][j] == 0 || !isValid(i, j, mat)) return MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        if (j == mat[0].length - 1) return 1;

        vis[i][j] = true;

        int up = 1 + rec(i - 1, j, mat, vis, dp);
        int down = 1 + rec(i + 1, j, mat, vis, dp);
        int right = 1 + rec(i, j + 1, mat, vis, dp);

        vis[i][j] = false;

        return dp[i][j] = Math.min(up, Math.min(down, right));
    }

    private boolean isValid(int i, int j, int[][] mat) {
        if (i - 1 >= 0 && mat[i - 1][j] == 0) return false;
        if (i + 1 < mat.length && mat[i + 1][j] == 0) return false;
        if (j + 1 < mat[0].length && mat[i][j + 1] == 0) return false;
        if (j - 1 >= 0 && mat[i][j - 1] == 0) return false;
        return true;
    }
}
