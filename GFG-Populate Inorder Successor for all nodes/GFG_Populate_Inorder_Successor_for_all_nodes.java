class Solution {
    Node next=null;
    
    public void populateNext(Node root) {
        // code here
        if(root==null) return;
        
        populateNext(root.right);
        root.next=next;
        next=root;
        populateNext(root.left);
    }
}
