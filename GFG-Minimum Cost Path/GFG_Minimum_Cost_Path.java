class Solution
{
   static class Cell {
        int x, y, cost;
        Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int[][] minCost = new int[n][n];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.cost));
        pq.add(new Cell(0, 0, grid[0][0]));
        minCost[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.x, y = current.y, cost = current.cost;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int newCost = cost + grid[nx][ny];
                    if (newCost < minCost[nx][ny]) {
                        minCost[nx][ny] = newCost;
                        pq.add(new Cell(nx, ny, newCost));
                    }
                }
            }
        }

        return minCost[n - 1][n - 1];
    }
}
