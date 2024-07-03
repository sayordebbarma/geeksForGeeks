class Solution {
    public Node removeAllDuplicates(Node head) {
        // code here
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;

        while (current != null) {
            if (current.next != null && current.data == current.next.data) {
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
