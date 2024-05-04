class Solution{
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        HashMap<Integer, Integer> map = new HashMap<>();
        verticalSumUtil(root, map, 0);

        // Extract vertical sums from the map
        int minKey = Integer.MAX_VALUE, maxKey = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            minKey = Math.min(minKey, key);
            maxKey = Math.max(maxKey, key);
        }

        for (int i = minKey; i <= maxKey; i++) {
            if (map.containsKey(i)) {
                result.add(map.get(i));
            } else {
                result.add(0);
            }
        }

        return result;
    }

    private void verticalSumUtil(Node node, HashMap<Integer, Integer> map, int verticalDistance) {
        if (node == null) return;

        // Update the vertical sum at the current vertical distance
        map.put(verticalDistance, map.getOrDefault(verticalDistance, 0) + node.data);

        // Recur for left and right subtrees with updated vertical distance
        verticalSumUtil(node.left, map, verticalDistance - 1);
        verticalSumUtil(node.right, map, verticalDistance + 1);
    }
}
