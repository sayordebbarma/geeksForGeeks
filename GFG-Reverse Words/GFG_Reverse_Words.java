class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        StringBuilder result = new StringBuilder();
        int n = str.length();
        int end = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '.') {
                result.append(str.substring(i + 1, end + 1)).append(".");
                end = i - 1; 
            }
        }
        result.append(str.substring(0, end + 1));

        return result.toString();
    }
}
