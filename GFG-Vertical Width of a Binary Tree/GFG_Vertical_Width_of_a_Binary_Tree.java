class Solution {
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {
        // code here.
        if (root == null) return 0;

        Set<Integer> set = new HashSet<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            set.add(hd);

            if (node.left != null) queue.add(new Pair(node.left, hd - 1));

            if (node.right != null) queue.add(new Pair(node.right, hd + 1));
        }

        return set.size();
    }

    static class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }

    }
}
