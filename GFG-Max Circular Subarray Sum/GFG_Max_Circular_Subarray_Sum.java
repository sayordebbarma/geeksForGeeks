class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int kadane(int arr[]) {
        int maxSum = arr[0], currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public int minKadane(int arr[]) {
        int minSum = arr[0], currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.min(arr[i], currentSum + arr[i]);
            minSum = Math.min(minSum, currentSum);
        }
        
        return minSum;
    }

    public int circularSubarraySum(int arr[]) {
        // Your code here
        int maxNormalSum = kadane(arr), totalSum = 0;
        for (int num : arr){
            totalSum += num;
        }
        
        int minNormalSum = minKadane(arr);
        return totalSum == minNormalSum ? maxNormalSum : Math.max(maxNormalSum, totalSum - minNormalSum);
    }
}
