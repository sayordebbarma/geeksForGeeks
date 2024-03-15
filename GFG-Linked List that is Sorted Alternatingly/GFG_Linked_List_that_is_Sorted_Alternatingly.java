class Solution {
    
   public Node sort(Node head) {
        //your code here, return the head of the sorted list
    Node smallHead = new Node(0);
    Node largeHead = new Node(0);
    Node smallTemp = smallHead, largeTemp = largeHead, current = head;
    boolean isSmall = true;

    while (current != null) {
        if (isSmall) {
            smallTemp.next = current;
            smallTemp = smallTemp.next;
        } else {
            largeTemp.next = current;
            largeTemp = largeTemp.next;
        }
        current = current.next;
        isSmall = !isSmall;
    }

    smallTemp.next = null;
    largeTemp.next = null;

    Node reversedLarge = reverseList(largeHead.next);
    Node sortedHead = new Node(0);
    Node sortedTemp = sortedHead;
    smallHead = smallHead.next;

    while (smallHead != null && reversedLarge != null) {
        if (smallHead.data <= reversedLarge.data) {
            sortedTemp.next = smallHead;
            smallHead = smallHead.next;
        } else {
            sortedTemp.next = reversedLarge;
            reversedLarge = reversedLarge.next;
        }
        sortedTemp = sortedTemp.next;
    }

    while (smallHead != null) {
        sortedTemp.next = smallHead;
        smallHead = smallHead.next;
        sortedTemp = sortedTemp.next;
    }

    while (reversedLarge != null) {
        sortedTemp.next = reversedLarge;
        reversedLarge = reversedLarge.next;
        sortedTemp = sortedTemp.next;
    }

    return sortedHead.next;
}

    private Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
    
        return prev;
   }
}
