class Solution {
    Node root;

    // Function to convert the binary tree into its mirror
    void mirror(Node node) {
        // Your code here
        if (node == null) return;

        mirror(node.left);
        mirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}
