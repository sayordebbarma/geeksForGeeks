class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[] prev = new long[n];
        long[] curr = new long[n];
        
        for (int j = 0; j < n; j++) {
            prev[j] = points[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            long[] leftToRight = new long[n];
            leftToRight[0] = prev[0];
            for (int j = 1; j < n; j++) {
                leftToRight[j] = Math.max(leftToRight[j - 1] - 1, prev[j]);
            }
            
            long[] rightToLeft = new long[n];
            rightToLeft[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightToLeft[j] = Math.max(rightToLeft[j + 1] - 1, prev[j]);
            }
            
            for (int j = 0; j < n; j++) {
                curr[j] = points[i][j] + Math.max(leftToRight[j], rightToLeft[j]);
            }
            
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        long maxPoints = 0;
        for (long point : prev) {
            maxPoints = Math.max(maxPoints, point);
        }
        
        return maxPoints;
    }
}
