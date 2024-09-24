class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        if (s.length() < p.length()) return "-1";

        HashMap<Character, Integer> freqP = new HashMap<>();
        for (char c : p.toCharArray()) {
            freqP.put(c, freqP.getOrDefault(c, 0) + 1);
        }

        int required = freqP.size();
        int left = 0, formed = 0;
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int[] minWindow = {-1, -1};

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (freqP.containsKey(c) && windowCounts.get(c).intValue() == freqP.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minWindow[0] = left;
                    minWindow[1] = right;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (freqP.containsKey(leftChar) && windowCounts.get(leftChar) < freqP.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        if (minWindow[0] == -1) return "-1";

        return s.substring(minWindow[0], minWindow[1] + 1);
    }
}
