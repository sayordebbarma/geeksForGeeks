class Solution {
    int largestSubsquare(int n, char a[][]) {
        // code here
        int rowPrefixSum[][] = new int[n][n];
        int colPrefixSum[][] = new int[n][n];
        
        // Calculate prefix sums for rows and columns
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                rowPrefixSum[i][j] = (a[i][j] == 'X' ? (j == 0 ? 1 : rowPrefixSum[i][j - 1] + 1) : 0);
                colPrefixSum[j][i] = (a[j][i] == 'X' ? (j == 0 ? 1 : colPrefixSum[j - 1][i] + 1) : 0);
            }
        }
        
        int maxSize = 0;
        
        // Iterate to find the largest subsquare
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int size = Math.min(rowPrefixSum[i][j], colPrefixSum[i][j]);
                
                while(size > maxSize) {
                    if(rowPrefixSum[i - size + 1][j] >= size && colPrefixSum[i][j - size + 1] >= size) {
                        maxSize = size;
                        break;
                    } else {
                        // Check for smaller sizes
                        size--;
                    }
                }
            }
        }
        
        return maxSize;
    }
}
