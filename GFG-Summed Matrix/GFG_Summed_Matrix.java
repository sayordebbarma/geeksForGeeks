class Solution {
    static long sumMatrix(long n, long q) {
        // code here
        long start = Math.max(1, q - n);
        long end = Math.min(n, q - 1);
        if (start > end) return 0;

        return end - start + 1;
    }
}
