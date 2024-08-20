class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    private static Node createParentMap(Node root, Map<Node, Node> parentMap, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == target) targetNode = current;
            
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }
        return targetNode;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        if (root == null) return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = createParentMap(root, parentMap, target);

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(targetNode);
        visited.add(targetNode);
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Burn the left child
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                    burned = true;
                }

                // Burn the right child
                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                    burned = true;
                }

                // Burn the parent
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    queue.add(parentMap.get(current));
                    visited.add(parentMap.get(current));
                    burned = true;
                }
            }

            if (burned) time++;
        }
        return time;
    }
}
