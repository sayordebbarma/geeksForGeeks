class Solution {
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        // code here
        head = reverse(head);

        Node current = head;
        int carry = 1;
        while (current != null) {
            int sum = current.data + carry;
            carry = sum / 10;
            current.data = sum % 10;

            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                carry = 0;
            }
            current = current.next;
        }

        head = reverse(head);

        return head;
    }
}
