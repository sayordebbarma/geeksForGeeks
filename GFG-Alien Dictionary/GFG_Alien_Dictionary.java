class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        boolean[] visited = new boolean[k];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            if (!visited[i]) topoSort(i, adj, visited, stack);
        }

        StringBuilder order = new StringBuilder();
        while (!stack.isEmpty()) {
            order.append((char) (stack.pop() + 'a'));
        }
        return order.toString();
    }

    private void topoSort(int v, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                topoSort(neighbor, adj, visited, stack);
            }
        }
        stack.push(v);
    }
}
