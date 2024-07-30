class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> paths = new ArrayList<>();
        int n = mat.length;
        if (mat[0][0] == 0 || mat[n-1][n-1] == 0) {
            return paths;
        }
        boolean[][] visited = new boolean[n][n];
        findPaths(mat, n, 0, 0, "", visited, paths);
        return paths;
    }
    
    private void findPaths(int[][] mat, int n, int i, int j, String path, boolean[][] visited, ArrayList<String> paths) {
        if (i == n-1 && j == n-1) {
            paths.add(path);
            return;
        }
        
        visited[i][j] = true;
        
        if (isSafe(mat, n, i+1, j, visited)) findPaths(mat, n, i+1, j, path + "D", visited, paths);
        
        if (isSafe(mat, n, i, j-1, visited)) findPaths(mat, n, i, j-1, path + "L", visited, paths);
        
        if (isSafe(mat, n, i, j+1, visited)) findPaths(mat, n, i, j+1, path + "R", visited, paths);
        
        if (isSafe(mat, n, i-1, j, visited)) findPaths(mat, n, i-1, j, path + "U", visited, paths);
        
        visited[i][j] = false;
    }
    
    private boolean isSafe(int[][] mat, int n, int i, int j, boolean[][] visited) {
        return (i >= 0 && i < n && j >= 0 && j < n && mat[i][j] == 1 && !visited[i][j]);
    }
}
