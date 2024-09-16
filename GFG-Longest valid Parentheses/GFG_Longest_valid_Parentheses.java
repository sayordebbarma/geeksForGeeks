class Solution{
    static int maxLength(String S){
        // code here
        Stack<Integer> stack = new Stack<>();
        
        stack.push(-1);
        
        int maxLength = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) stack.push(i);
                else maxLength = Math.max(maxLength, i - stack.peek());
            }
        }
        
        return maxLength;
    }
}
