class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int weight = current[1];

            if (weight > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int adj = neighbor[0];
                int d = neighbor[1];
                if (dist[adj] > weight + d) {
                    dist[adj] = weight + d;
                    pq.add(new int[]{adj, dist[adj]});
                    parent[adj] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }

        for (int at = n; at != 0; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        path.add(0, dist[n]);

        return path;
    }
}
