class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int n = arr.length;
        int maxProduct = arr[0];
        int currentMax = arr[0];
        int currentMin = arr[0];
        
        for (int i = 1; i < n; i++) {
            if (arr[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            
            currentMax = Math.max(arr[i], currentMax * arr[i]);
            currentMin = Math.min(arr[i], currentMin * arr[i]);
            
            maxProduct = Math.max(maxProduct, currentMax);
        }
        
        return maxProduct;
    }
}
