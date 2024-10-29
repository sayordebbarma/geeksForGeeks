/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

}*/
// you have to complete this function
class GfG {
    public static void splitList(Node pivot, Node[] smaller, Node[] larger) {
        Node current = pivot.next;
        while (current != null) {
            Node nextNode = current.next;
            if (current.data <= pivot.data) {
                current.next = smaller[0];
                smaller[0] = current;
            } else {
                current.next = larger[0];
                larger[0] = current;
            }
            current = nextNode;
        }
    }
    
    public static Node quickSort(Node head) {
        // Your code here
        if (head == null || head.next == null) return head;

        Node[] smaller = new Node[1];
        Node[] larger = new Node[1];
        splitList(head, smaller, larger);

        smaller[0] = quickSort(smaller[0]);
        larger[0] = quickSort(larger[0]);

        Node tail = smaller[0];
        while (tail != null && tail.next != null) tail = tail.next;

        if (tail != null) tail.next = head;
        else smaller[0] = head;

        head.next = larger[0];
        return smaller[0];
    }
}
