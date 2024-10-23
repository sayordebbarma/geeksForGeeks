/*
Node class is as follows:

class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {

    // Return the sum of last k nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        // write code here
        if (head == null) return 0;

        Node first = head;
        Node second = head;

        for (int i = 0; i < n; i++) {
            if (first != null) first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        int sum = 0;
        while (second != null) {
            sum += second.data;
            second = second.next;
        }

        return sum;
    }
}
