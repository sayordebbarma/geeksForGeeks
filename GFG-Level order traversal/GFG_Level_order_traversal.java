class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node root) 
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Node curr = queue.remove();
            
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
            
            result.add(curr.data);
        }
        
        return result;
    }
}
