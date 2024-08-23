class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                
                if (i == 0) result.add(currentNode.data);
                
                if (currentNode.left != null) queue.add(currentNode.left);
                
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
        
        return result;
    }
}
