class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if (head == null || head.next == null) return null;

        Node slowPtr = head;
        Node fastPtr = head;
        Node prevNode = null;

        while (fastPtr != null && fastPtr.next != null) {
            prevNode = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        prevNode.next = slowPtr.next;

        return head;
    }
}
