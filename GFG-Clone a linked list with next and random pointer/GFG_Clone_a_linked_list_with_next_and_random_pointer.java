class Solution {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        if (head == null) return null;

        Node current = head;
        while (current != null) {
            Node copy = new Node(current.data);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) current.next.random = current.random.next;
            current = current.next.next;
        }

        current = head;
        Node dummyHead = new Node(0);
        Node copyCurrent = dummyHead;

        while (current != null) {
            Node nextOriginal = current.next.next;

            copyCurrent.next = current.next;
            copyCurrent = copyCurrent.next;

            current.next = nextOriginal;
            current = nextOriginal;
        }

        return dummyHead.next;
    }
}
