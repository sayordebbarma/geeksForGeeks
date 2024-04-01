class Solution {
    static int k;
    
    public static int pairsViolatingBST(int n, Node root) {
        // code here
        int count = 0;
        k = 0;
        int[] nodeValues = new int[n];
        inorderTraversal(root, nodeValues);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nodeValues[i] > nodeValues[j])
                    count++;
            }
        }
        return count;
    }

    static void inorderTraversal(Node node, int[] nodeValues) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, nodeValues);
        nodeValues[k++] = node.data;
        inorderTraversal(node.right, nodeValues);
    }
}
