class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int row = 0, col = 0, dir = 0;
        
        while (true) {
            if (row < 0 || row >= n || col < 0 || col >= m) {
                break;
            }
            
            if (matrix[row][col] == 1) {
                dir = (dir + 1) % 4;
                matrix[row][col] = 0;
            }
            
            row += directions[dir][0];
            col += directions[dir][1];
        }
        
        return new int[]{row - directions[dir][0], col - directions[dir][1]};
    }
}
