class Solution
{
    Node head = null, prev = null;

    Node bToDLL(Node root)
    {
        convertToDLL(root);
        return head;
    }

    void convertToDLL(Node root) {
        // code here
        if (root == null) return;

        convertToDLL(root.left);

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        convertToDLL(root.right);
    }
}
