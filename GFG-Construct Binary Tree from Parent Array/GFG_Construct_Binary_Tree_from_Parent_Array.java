class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        // Your code here
        int n = parent.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        Node root = null;

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = nodes[i];
            } else {
                Node parentNode = nodes[parent[i]];
                if (parentNode.left == null) parentNode.left = nodes[i];
                else parentNode.right = nodes[i];
            }
        }

        return root;
    }
}
