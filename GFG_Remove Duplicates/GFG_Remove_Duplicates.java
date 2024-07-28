class Solution {
    String removeDups(String str) {
        // code here
        int[] fre = new int[26]; 
        StringBuilder result = new StringBuilder(); 
        
        for (char c : str.toCharArray()) {
            if (fre[c - 'a'] == 0) { 
                result.append(c); 
                fre[c - 'a'] = 1; 
            }
        }
        
        return result.toString();

    }
}
