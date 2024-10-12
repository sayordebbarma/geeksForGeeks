class Solution {
    public int pairWithMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        if (n < 2) return -1;
        
        int maxSum = -1;
        
        for (int i = 1; i < n; i++) {
            int sum = arr[i] + arr[i - 1];
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}
