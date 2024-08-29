class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // Add your code here.
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) return countLoopLength(slow);
        }

        return 0;
    }

    private static int countLoopLength(Node nodeInLoop) {
        int count = 1;
        Node temp = nodeInLoop;

        while (temp.next != nodeInLoop) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
