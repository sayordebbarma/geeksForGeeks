class Solution {

    int[] Series(int n) {
        // code here
        int modulo = (int) 1e9 + 7;
        int[] fibonacci = new int[n + 1];
        
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % modulo;
        }

        return fibonacci;
    }
}
