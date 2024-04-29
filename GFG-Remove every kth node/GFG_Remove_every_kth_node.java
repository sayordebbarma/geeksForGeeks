class Solution
{
    /*You are required to complete this method*/
    Node delete(Node head, int k)
    {
        // Your code here	
	    if (head == null || k <= 0) return head;

        if (k == 1) return null;

        Node current = head;
        Node prev = null;
        int count = 0;

        while (current != null) {
            count++;
            if (count % k == 0) {
                if (prev != null) prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }

        return head;
    }
}
