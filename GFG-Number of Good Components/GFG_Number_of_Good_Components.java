class Solution {
    static int V_count;
    static int E_count;
    static boolean[] visited;
    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[v + 1];
        int ans = 0;
        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                V_count = E_count = 0;
                dfs(adj, i);

                if (E_count == V_count * (V_count - 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int st) {
        visited[st] = true;
        V_count++;
        E_count += adj.get(st).size();
        for (int nei : adj.get(st)) {
            if (!visited[nei]) {
                dfs(adj, nei);
            }
        }
    }
}
