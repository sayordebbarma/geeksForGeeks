    int n = grid.length;
    int maxArea = 0;
    Integer[][] visited = new Integer[n][n];
    List<Integer> componentSizes = new ArrayList<>();
    int colorId = 0;

    for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
            if (visited[row][col] == null && grid[row][col] == 1) {
                int componentSize = exploreComponent(row, col, n, visited, grid, colorId);
                componentSizes.add(componentSize);
                maxArea = Math.max(maxArea, componentSize);
                colorId++;
            }
        }
    }

    for (int row = 0; row < n; row++) {
        for (int col = 0; col < n; col++) {
            if (grid[row][col] == 0) {
                Set<Integer> adjacentColors = new HashSet<>();
                if (row > 0) adjacentColors.add(visited[row - 1][col]);
                if (row < n - 1) adjacentColors.add(visited[row + 1][col]);
                if (col > 0) adjacentColors.add(visited[row][col - 1]);
                if (col < n - 1) adjacentColors.add(visited[row][col + 1]);

                int potentialSize = 1;
                for (Integer color : adjacentColors) {
                    if (color != null) {
                        potentialSize += componentSizes.get(color);
                    }
                }

                maxArea = Math.max(maxArea, potentialSize);
            }
        }
    }

    return maxArea;
}

private int exploreComponent(int row, int col, int n, Integer[][] visited, int[][] grid, int colorId) {
    if (row < 0 || col < 0 || row >= n || col >= n || visited[row][col] != null || grid[row][col] == 0) {
        return 0;
    }

    visited[row][col] = colorId;
    int componentSize = 1;

    componentSize += exploreComponent(row + 1, col, n, visited, grid, colorId);
    componentSize += exploreComponent(row - 1, col, n, visited, grid, colorId);
    componentSize += exploreComponent(row, col + 1, n, visited, grid, colorId);
    componentSize += exploreComponent(row, col - 1, n, visited, grid, colorId);

    return componentSize;
