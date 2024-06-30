class Solution {
    public Node deleteNode(Node head, int x) {
        if (head == null || x <= 0) return head;

        Node current = head;

        if (x == 1) {
            head = current.next;
            if (head != null) head.prev = null;
            
            return head;
        }

        for (int i = 1; current != null && i < x; i++) {
            current = current.next;
        }

        if (current == null) return head;

        if (current.next != null) current.next.prev = current.prev;

        if (current.prev != null) current.prev.next = current.next;

        return head;
    }
}
