class Solution {
    int findMaxSum(int N, int M, int Mat[][]) {
        // code here
        if (N < 3 || M < 3) return -1;

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < N - 2; ++i) {
            for (int j = 0; j < M - 2; ++j) {
                int sum = Mat[i][j] + Mat[i][j + 1] + Mat[i][j + 2] + Mat[i + 1][j + 1] + 
                            Mat[i + 2][j] + Mat[i + 2][j + 1] + Mat[i + 2][j + 2];

                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
};
