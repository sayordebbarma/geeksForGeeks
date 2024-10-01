class Solution {
    private static final int MOD = 1000000007;
    
    private long listToNumber(Node head) {
        long num = 0;
        while (head != null) {
            num = (num * 10 + head.data) % MOD;
            head = head.next;
        }
        return num;
    }

    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        long num1 = listToNumber(first);
        long num2 = listToNumber(second);
        
        return (num1 * num2) % MOD;
    }
}
