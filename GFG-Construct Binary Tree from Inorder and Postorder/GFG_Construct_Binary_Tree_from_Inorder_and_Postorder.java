class GfG
{
    Map<Integer, Integer> indexMap = new HashMap<>();
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        for (int i = 0; i < n; ++i)
            indexMap.put(in[i], i);

        int postIndex = n - 1; 
        return buildTreeHelper(in, post, 0, n - 1, postIndex);
    }
    
    private Node buildTreeHelper(int in[], int post[], int inStart, int inEnd, int postIndex) {
        if (inStart > inEnd || postIndex < 0) return null;

        Node root = new Node(post[postIndex]); 
        int inIndex = indexMap.get(root.data); 
        int rightSubtreeSize = inEnd - inIndex;

        root.right = buildTreeHelper(in, post, inIndex + 1, inEnd, postIndex - 1);
        root.left = buildTreeHelper(in, post, inStart, inIndex - 1, postIndex - rightSubtreeSize - 1);

        return root;
    }
}
