class Solution {
    private final int[][] directions = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0},  // Horizontal and vertical
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Diagonals
    };
    
    private void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        
        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            dfs(grid, newRow, newCol, n, m);
        }
    }
    
    // Main function to count the number of islands
    public int numIslands(char[][] grid) {
        // Get the dimensions of the grid
        int n = grid.length;
        int m = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, n, m);
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
}
