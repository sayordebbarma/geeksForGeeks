class Solution {
    boolean kPangram(String str, int k) {
        // code here
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c))
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        int cnt = 0;
        int uniq = 0;
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (Character.isAlphabetic(entry.getKey())) {
                cnt += entry.getValue();
                uniq++;
            }
        }

        return cnt >= 26 && (26 - uniq) <= k;

    }
}
