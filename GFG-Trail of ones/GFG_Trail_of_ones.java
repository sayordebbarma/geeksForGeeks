class Solution {
    static int numberOfConsecutiveOnes(int n) {
        // code here
        final long MOD = 1_000_000_007;
        if (n == 1 || n == 2) {
            return 1;
        }
        long a = 1, b = 1;
        long res = 1;
        for (int i = 3; i <= n; i++) {
            long c = (a + b) % MOD; 
            a = b;
            b = c;
            res = (res * 2 + a) % MOD;
        }
        return (int) res;
    }
}
