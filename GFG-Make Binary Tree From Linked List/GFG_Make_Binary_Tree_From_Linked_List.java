class Solution {
    public Tree convert(Node head, Tree node) {
        if (head == null) return null;

        Tree root = new Tree(head.data);

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        Node current = head.next;

        while (current != null) {
            Tree parent = queue.poll();

            Tree leftChild = new Tree(current.data);
            parent.left = leftChild;
            queue.add(leftChild);
            current = current.next;

            if (current != null) {
                Tree rightChild = new Tree(current.data);
                parent.right = rightChild;
                queue.add(rightChild);
                current = current.next;
            }
        }

        return root;
    }

    public void levelOrderTraversal(Tree root) {
        if (root == null) return;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) queue.add(tempNode.left);

            if (tempNode.right != null) queue.add(tempNode.right);
        }
    }
}
