class Solution {
    public static String oddEven(String s) {
        // code here
        int x = 0, y = 0;
        int[] count = new int[26];
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] % 2 == 0 && (i + 1) % 2 == 0) {
                    x++;
                } else if (count[i] % 2 == 1 && (i + 1) % 2 == 1) {
                    y++;
                }
            }
        }
        
        int sum = x + y;
        return (sum % 2 == 1) ? "ODD" : "EVEN";

    }
}
