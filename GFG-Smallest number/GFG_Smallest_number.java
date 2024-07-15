class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if (s > 9 * d) return "-1";

        char[] result = new char[d];
        Arrays.fill(result, '0');
        s--;

        for (int i = d - 1; i >= 0; i--) {
            if (s > 9) {
                result[i] = '9';
                s -= 9;
            } else {
                result[i] = (char) ('0' + s);
                s = 0;
            }
        }
        
        result[0] = (char) (result[0] + 1); 
        return new String(result);
    }
}
