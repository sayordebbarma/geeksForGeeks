class Solution {
    public boolean isLengthEven(Node head) {
        // code here
        boolean isEven = true;
        while (head != null) {
            isEven = !isEven;
            head = head.next;
        }
        return isEven;
    }
}
