class Solution{
    static class BSTInfo {
        int size;
        int min;
        int max;
        boolean isBST;

        BSTInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        // Write your code here
        return largestBSTUtil(root).size;
    }
    
    private static BSTInfo largestBSTUtil(Node node) {
        if (node == null) {
            return new BSTInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        BSTInfo left = largestBSTUtil(node.left);
        BSTInfo right = largestBSTUtil(node.right);

        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            int size = left.size + right.size + 1;
            int min = Math.min(node.data, left.min);
            int max = Math.max(node.data, right.max);
            return new BSTInfo(size, min, max, true);
        }

        return new BSTInfo(Math.max(left.size, right.size), 0, 0, false);
    }
}
