class Solution {
    private Map<String, Integer> subtreeMap = new HashMap<>();
    private List<Node> duplicateRoots = new ArrayList<>();
    
    private String serialize(Node root) {
        if (root == null) return "#";

        String serialized = root.data + "," + serialize(root.left) + "," + serialize(root.right);
        
        subtreeMap.put(serialized, subtreeMap.getOrDefault(serialized, 0) + 1);
        
        if (subtreeMap.get(serialized) == 2) duplicateRoots.add(root);

        return serialized;
    }
    
    public List<Node> printAllDups(Node root) {
        // code here
        serialize(root);
        return duplicateRoots;
    }
}
