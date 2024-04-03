class Solution {
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        int totalCount = 1;
        Node currentNode = root;
    
        while (currentNode != null) {
            if (currentNode.data > x && currentNode.data > y) {
                currentNode = currentNode.left;
                totalCount++;
            } else if (currentNode.data < x && currentNode.data < y) {
                currentNode = currentNode.right;
                totalCount++;
            } else {
                break;
            }
        }
    
        int currentPosition = 1;
        totalCount -= k;
        totalCount++;
        currentNode = root;
    
        while (currentNode != null) {
            if (currentPosition == totalCount) {
                return currentNode.data;
            }
            if (currentNode.data > x && currentNode.data > y) {
                currentNode = currentNode.left;
                currentPosition++;
            } else if (currentNode.data < x && currentNode.data < y) {
                currentNode = currentNode.right;
                currentPosition++;
            } else {
                break;
            }
        }
    
        return -1;
    }
}
