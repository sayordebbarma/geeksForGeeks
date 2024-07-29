class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
        int maxRowIndex = -1;
        int col = m - 1;

        for (int row = 0; row < n; row++) {
            while (col >= 0 && arr[row][col] == 1) {
                maxRowIndex = row;
                col--;
            }
        }

        return maxRowIndex;
    }
}
