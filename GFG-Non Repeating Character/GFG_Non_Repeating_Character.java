class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s.toCharArray()) {
            if (freqMap.get(c) == 1) return c;
        }
        
        return '$';
    }
}
