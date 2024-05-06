class Tree
{
    void help(Node root, ArrayList<Integer> ans) {
        if (root == null) return;
        if (root.left == null || root.right == null) {
            if (root.left != null) ans.add(root.left.data);
            if (root.right != null) ans.add(root.right.data);
        }
        help(root.left, ans);
        help(root.right, ans);
    }

    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        help(node, ans);
        Collections.sort(ans);
        if (ans.isEmpty()) ans.add(-1);
        return ans;
    }
}
