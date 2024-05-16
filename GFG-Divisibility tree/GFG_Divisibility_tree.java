class Solution {
    int ans = 0;

    int dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        int cnt = 0;
        vis[v] = true;
        for (int u : adj.get(v)) {
            if (!vis[u]) {
                int res = dfs(u, adj, vis);
                if (res % 2 == 0)
                    ans++;
                else
                    cnt += res;
            }
        }
        return cnt + 1;
    }

    public int minimumEdgeRemove(int n, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n];
        for (int[] edge : edges) {
            adj.get(edge[0] - 1).add(edge[1] - 1);
            adj.get(edge[1] - 1).add(edge[0] - 1);
        }
        dfs(0, adj, vis);
        return ans;
    }
}
