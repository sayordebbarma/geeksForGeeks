class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        if (head == null || head.next == null) return head;
        
        Node vowel = new Node('a');
        Node con = new Node('b');
        Node vowelH = vowel;
        Node conH = con;
        
        while (head != null) {
            char temp = head.data;
            if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
                vowel.next = head;
                vowel = vowel.next;
            } else {
                con.next = head;
                con = con.next;
            }
            head = head.next;
        }
        
        con.next = null;
        vowel.next = conH.next;
        
        return vowelH.next;
    }
}
