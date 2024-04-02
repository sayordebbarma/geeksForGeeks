class Solution
{
    private int prev;
    private int ans;
    
    int absolute_diff(Node root)
    {
        //Your code here
        ans = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;
        inorderTraversal(root);
        return ans;
    }
    
    private void inorderTraversal(Node root) {
        if (root == null) return;

        inorderTraversal(root.left);

        if (prev != Integer.MAX_VALUE) ans = Math.min(ans, root.data - prev);
        
        prev = root.data;

        inorderTraversal(root.right);
    }
}
