class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int[] queens = new int[n];
        solve(0, queens, results, n);
        return results;
    }

    private void solve(int col, int[] queens, ArrayList<ArrayList<Integer>> results, int n) {
        if (col == n) {
            ArrayList<Integer> solution = new ArrayList<>();
            for (int queen : queens) {
                solution.add(queen + 1);
            }
            results.add(solution);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(col, row, queens)) {
                queens[col] = row;
                solve(col + 1, queens, results, n);
            }
        }
    }

    private boolean isSafe(int col, int row, int[] queens) {
        for (int i = 0; i < col; i++) {
            int placedRow = queens[i];
            if (placedRow == row || Math.abs(placedRow - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
}
