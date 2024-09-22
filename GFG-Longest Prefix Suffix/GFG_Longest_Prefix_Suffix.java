class Solution {
    int lps(String str) {
        // code here
        int n = str.length();
        
        int[] res = new int[n];
        
        int len = 0;
        int i = 1;
        
        res[0] = 0;
        
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                res[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = res[len - 1];
                } else {
                    res[i] = 0;
                    i++;
                }
            }
        }
        
        return res[n - 1];
    }
}
