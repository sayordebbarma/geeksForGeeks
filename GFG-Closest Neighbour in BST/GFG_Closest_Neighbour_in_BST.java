class Solution {
    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        if (root == null) return -1;
        
        if (root.key == n) {
            return n;
        } else if (root.key < n) {
            int rightMax = findMaxForN(root.right, n);
            if (rightMax != -1) return rightMax;
            else return root.key;
        } else {
            return findMaxForN(root.left, n);
        }
    }
}
