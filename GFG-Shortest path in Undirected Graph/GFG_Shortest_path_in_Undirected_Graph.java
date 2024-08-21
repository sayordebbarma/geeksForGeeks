class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        
        dist[src] = 0;
        queue.offer(src);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentDist = dist[node];
            
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = currentDist + 1;
                    queue.offer(neighbor);
                }
            }
        }
        
        return dist;
    }
}
