/*class of the node of the DLL is as
/*
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
*/
class Solution {
    public Node sortedInsert(Node head, int x) {
        // add your code here
        Node newNode = new Node(x);

        if (head == null || head.data >= x) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            
            return newNode;
        }

        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }

        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;

        if (newNode.next != null) newNode.next.prev = newNode;

        return head;
    }
}
