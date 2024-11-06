/*
class Tree
{
      int data;
      Tree left,right;
      Tree(int d){
          data=d;
          left=null;
          right=null;
}
}*/
class Solution {
    public static int treePathsSum(Node root) {
        // add code here.
        return calculatePathSum(root, 0);
    }
    
    private static int calculatePathSum(Node node, int currentSum) {
        if (node == null) return 0;
        
        currentSum = 10 * currentSum + node.data;
        
        if (node.left == null && node.right == null) return currentSum;

        int leftSum = calculatePathSum(node.left, currentSum);
        int rightSum = calculatePathSum(node.right, currentSum);
        
        return leftSum + rightSum;
    }
}
