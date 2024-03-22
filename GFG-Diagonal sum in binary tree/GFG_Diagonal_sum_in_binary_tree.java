class Tree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        // code here.
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(Node root, int level, ArrayList<Integer> res) {
        if (root == null) return;

        if (res.size() <= level) {
            res.add(root.data);
        } else {
            res.set(level, res.get(level) + root.data);
        }

        dfs(root.right, level, res);
        dfs(root.left, level + 1, res);
    }
}
