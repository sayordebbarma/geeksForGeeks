class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
    
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;
    
        currentLevel.push(root);
    
        while (!currentLevel.isEmpty()) {
            Node node = currentLevel.pop();
            result.add(node.data);
    
            if (leftToRight) {
                if (node.left != null) nextLevel.push(node.left);
                if (node.right != null) nextLevel.push(node.right);
            } else {
                if (node.right != null) nextLevel.push(node.right);
                if (node.left != null) nextLevel.push(node.left);
            }
    
            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    
        return result;
	}
}
