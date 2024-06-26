class Solution {
    public int findCoverage(int[][] matrix) {
        // code here
        int n = matrix.length;
        int m = matrix[0].length;
        int totalCoverage = 0;

        int[] rowDirections = {-1, 1, 0, 0};
        int[] colDirections = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    int coverage = 0;
                    
                    for (int d = 0; d < 4; d++) {
                        int newRow = i + rowDirections[d];
                        int newCol = j + colDirections[d];
                        
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && matrix[newRow][newCol] == 1) {
                            coverage++;
                        }
                    }
                    
                    totalCoverage += coverage;
                }
            }
        }
        
        return totalCoverage;
    }
}
