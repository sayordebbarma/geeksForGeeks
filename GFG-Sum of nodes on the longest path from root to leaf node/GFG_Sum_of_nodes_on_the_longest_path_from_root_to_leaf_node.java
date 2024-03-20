class Solution{
    static int maxSum = Integer.MIN_VALUE;
    static int maxCount = 0;

    static void calculateLongestPath(Node root, int sum, int count) {
        if (root == null) {
            if (count > maxCount) {
                maxSum = sum;
                maxCount = count;
            } else if (count == maxCount) {
                maxSum = Math.max(maxSum, sum);
            }
            return;
        }
        
        sum += root.data;
        count++;
        
        calculateLongestPath(root.left, sum, count);
        calculateLongestPath(root.right, sum, count);
    }

    public int sumOfLongRootToLeafPath(Node root) {
        //code here
        int sum = 0;
        int count = 0;
        
        maxSum = Integer.MIN_VALUE;
        maxCount = 0;
        
        calculateLongestPath(root, sum, count);
        
        return maxSum;
    }
}
