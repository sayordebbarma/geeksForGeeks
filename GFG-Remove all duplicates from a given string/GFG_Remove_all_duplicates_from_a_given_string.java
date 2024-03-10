class Solution {
    String removeDuplicates(String str) {
        Set<Character> unique = new HashSet<>();
        StringBuilder result = new StringBuilder();
        
        for(char c : str.toCharArray()) {
            if(!unique.contains(c)) {
                result.append(c);
                unique.add(c);
            }
        }
        
        return result.toString();
    }
}
