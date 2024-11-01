class Solution {
    public long maxSum(Long[] arr) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        
        Long[] newArr = new Long[n];
        int left = 0, right = n - 1;
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) newArr[i] = arr[left++];
            else newArr[i] = arr[right--];
        }
        
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += Math.abs(newArr[i] - newArr[(i + 1) % n]);
        }
        
        return maxSum;
    }
}
