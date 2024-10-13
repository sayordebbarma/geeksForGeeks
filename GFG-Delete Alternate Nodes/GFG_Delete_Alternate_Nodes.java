class Solution {
    public void deleteAlt(Node head) {
        // Code Here
        if (head == null) return;  
        Node current = head;

        while (current != null && current.next != null) {
            Node temp = current.next;  
            current.next = current.next.next;  
            temp = null;  
            current = current.next;
        }

    }
}
