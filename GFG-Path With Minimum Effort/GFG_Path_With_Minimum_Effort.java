class Solution {
    static class Cell implements Comparable<Cell> {
        int row, col, effort;

        public Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        @Override
        public int compareTo(Cell other) {
            return this.effort - other.effort;
        }
    }

    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        int[][] efforts = new int[rows][columns];
        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        minHeap.offer(new Cell(0, 0, 0));
        efforts[0][0] = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!minHeap.isEmpty()) {
            Cell current = minHeap.poll();

            if (current.row == rows - 1 && current.col == columns - 1) {
                return current.effort;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = current.row + dx[i];
                int newCol = current.col + dy[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                    int newEffort = Math.max(current.effort, Math.abs(heights[newRow][newCol] - heights[current.row][current.col]));

                    if (newEffort < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = newEffort;
                        minHeap.offer(new Cell(newRow, newCol, newEffort));
                    }
                }
            }
        }

        return -1;
    }
}
