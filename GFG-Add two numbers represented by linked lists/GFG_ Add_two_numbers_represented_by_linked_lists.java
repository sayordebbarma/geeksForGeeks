class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node sum = null;
        int carry = 0;

        while (num1 != null || num2 != null || carry > 0) {
            int newVal = carry;

            if (num1 != null) {
                newVal += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                newVal += num2.data;
                num2 = num2.next;
            }

            carry = newVal / 10;
            newVal = newVal % 10;
            Node newNode = new Node(newVal);
            newNode.next = sum;
            sum = newNode;
        }

        while (sum != null && sum.data == 0) {
            Node temp = sum.next;
            sum.next = null;
            sum = temp;
        }

        if (sum == null)
            return new Node(0);
        return sum;
    }
    
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
