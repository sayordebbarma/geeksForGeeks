class Solution {
    int[] visitedNodes;
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        visitedNodes = new int[v+1];

        dfs(0, visitedNodes, adj);
        for (int i = 0; i<v; i++) {
            if (visitedNodes[i] == 0 && adj.get(i).size() > 0) return false;
        }
        
        // 1/2
        int cnt = 0;
        for (int i=0; i < v; i++) {
            if ((adj.get(i).size() % 2) == 1) cnt++;
        }

        if (cnt > 2) return false;
        else if(cnt==2) return false;
        else return true; 
    }
    
    void dfs(int u, int[] visitedNodes, ArrayList<ArrayList<Integer>> adj) {
        visitedNodes[u] = 1;
        for (int v : adj.get(u)) {
            if (visitedNodes[v]==0) dfs(v, visitedNodes, adj);
        }
    }
}
