class Solution {
    public DLLNode sortAKSortedDLL(DLLNode head, int k) {
        // Code here
        if (head == null) return null;

        PriorityQueue<DLLNode> minHeap = new PriorityQueue<>((a, b) -> a.data - b.data);

        DLLNode newHead = null, lastSorted = null;

        DLLNode curr = head;
        for (int i = 0; curr != null && i <= k; i++) {
            minHeap.add(curr);
            curr = curr.next;
        }

        while (!minHeap.isEmpty()) {
            DLLNode minNode = minHeap.poll();

            if (newHead == null) {
                newHead = minNode;
                newHead.prev = null;
                lastSorted = newHead;
            } else {
                lastSorted.next = minNode;
                minNode.prev = lastSorted;
                lastSorted = minNode;
            }

            if (curr != null) {
                minHeap.add(curr);
                curr = curr.next;
            }
        }

        lastSorted.next = null;

        return newHead;
    }
}
