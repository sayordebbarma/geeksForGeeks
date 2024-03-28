class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
            //code here
            int ans = -1;
            int minCitiesCount = n;
            int[][] dist = computeDistances(n, edges, distanceThreshold);
    
            for (int i = 0; i < n; ++i) {
                int citiesCount = countReachableCities(dist[i], distanceThreshold);
                if (citiesCount <= minCitiesCount) {
                    ans = i;
                    minCitiesCount = citiesCount;
                }
            }
    
            return ans;
        }

        private int[][] computeDistances(int n, int[][] edges, int distanceThreshold) {
            int[][] dist = new int[n][n];
            Arrays.stream(dist).forEach(row -> Arrays.fill(row, distanceThreshold + 1));
    
            for (int i = 0; i < n; ++i)
                dist[i][i] = 0;
    
            for (int[] edge : edges) {
                final int u = edge[0];
                final int v = edge[1];
                final int w = edge[2];
                dist[u][v] = w;
                dist[v][u] = w;
            }
    
            for (int k = 0; k < n; ++k)
                for (int i = 0; i < n; ++i)
                    for (int j = 0; j < n; ++j)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    
            return dist;
        }
    
        private int countReachableCities(int[] distances, int threshold) {
            int count = 0;
            for (int dist : distances) {
                if (dist <= threshold)
                    count++;
            }
            return count;
        }
}
