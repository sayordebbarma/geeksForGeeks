class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        if (root == null) return -1;

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }
}
