class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            
            if (mat[a][b] == 1) stack.push(b);
            else stack.push(a);
        }
        
        if (stack.isEmpty()) return -1;
        
        int potentialCelebrity = stack.pop();
        
        for (int i = 0; i < n; i++) {
            if (i != potentialCelebrity && mat[potentialCelebrity][i] == 1) {
                return -1;
            }

            if (i != potentialCelebrity && mat[i][potentialCelebrity] == 0) {
                return -1;
            }
        }
        
        return potentialCelebrity;
    }
}
