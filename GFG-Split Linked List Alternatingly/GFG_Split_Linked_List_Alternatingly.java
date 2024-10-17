class Solution {
    // Function to split a linked list into two lists with alternating nodes
    Node[] alternatingSplitList(Node head) {
        // code here
        if (head == null) return new Node[]{null, null};

        Node firstList = null, secondList = null;
        Node firstTail = null, secondTail = null;

        boolean isFirst = true;

        Node curr = head;
        while (curr != null) {
            if (isFirst) {
                if (firstList == null) {
                    firstList = curr;
                    firstTail = firstList;
                } else {
                    firstTail.next = curr;
                    firstTail = firstTail.next;
                }
            } else {
                if (secondList == null) {
                    secondList = curr;
                    secondTail = secondList;
                } else {
                    secondTail.next = curr;
                    secondTail = secondTail.next;
                }
            }

            isFirst = !isFirst;

            curr = curr.next;
        }

        if (firstTail != null) firstTail.next = null;
        
        if (secondTail != null) secondTail.next = null;

        return new Node[]{firstList, secondList};
    }
}
