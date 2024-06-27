class Solution {
    /*You are required to complete this method*/
    boolean isToeplitz(int mat[][]) {
        // Your code here
        int rows = mat.length;
        int cols = mat[0].length;

        for (int col = 0; col < cols - 1; col++) {
            if (!checkDiagonal(mat, 0, col)) return false;
        }

        for (int row = 1; row < rows - 1; row++) {
            if (!checkDiagonal(mat, row, 0)) return false;
        }

        return true;
    }

    private static boolean checkDiagonal(int[][] mat, int startRow, int startCol) {
        int rows = mat.length;
        int cols = mat[0].length;
        int value = mat[startRow][startCol];

        int row = startRow + 1;
        int col = startCol + 1;

        while (row < rows && col < cols) {
            if (mat[row][col] != value) return false;
            
            row++;
            col++;
        }

        return true;
    }
}
