class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k && (i + j) < n; j++) {
                int cost = Math.abs(arr[i] - arr[i + j]);
                dp[i + j] = Math.min(dp[i + j], dp[i] + cost);
            }
        }

        return dp[n - 1];
    }
}
