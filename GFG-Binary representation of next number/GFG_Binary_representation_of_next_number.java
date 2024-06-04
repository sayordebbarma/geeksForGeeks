class Solution {
    String binaryNextNumber(String s) {
        // code here.
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int carry = 1;

        for (int i = 0; i < sb.length() && carry == 1; i++) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                carry = 0;
            } else {
                sb.setCharAt(i, '0');
                carry = 1;
            }
        }

        if (carry == 1) sb.append('1');

        sb.reverse();
        
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        return sb.substring(idx);
    }
}
