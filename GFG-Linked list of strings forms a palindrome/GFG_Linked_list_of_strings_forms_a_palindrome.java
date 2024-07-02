class Solution {
    public boolean compute(Node root) {
        StringBuilder ans = new StringBuilder();
        Node t = root;
        while (t != null) {
            ans.append(t.data);
            t = t.next;
        }
        int i = 0, j = ans.length() - 1;
        while (i < j) {
            if (ans.charAt(i) != ans.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
