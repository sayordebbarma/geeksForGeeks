class Solution {
    public String printString(String s, char ch, int count) {
        // code here
        int n = s.length();
        int occurrences = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ch) occurrences++;

            if (occurrences == count) return s.substring(i + 1);
        }
        
        return "";
    }
}
