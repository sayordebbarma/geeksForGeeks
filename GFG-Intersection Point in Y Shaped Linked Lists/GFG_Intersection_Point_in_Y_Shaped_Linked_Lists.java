/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        // code here
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        int diff = Math.abs(length1 - length2);

        Node longer = length1 > length2 ? head1 : head2;
        Node shorter = length1 > length2 ? head2 : head1;

        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }

        while (longer != null && shorter != null) {
            if (longer == shorter) return longer.data;
            longer = longer.next;
            shorter = shorter.next;
        }

        return -1;
    }

    int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
