class Solution {
    int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        int rows = mat.length;
        int cols = mat[0].length;
        k = k % cols;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int newCol = (j - k + cols) % cols;
                result[i][newCol] = mat[i][j];
            }
        }

        return result;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
