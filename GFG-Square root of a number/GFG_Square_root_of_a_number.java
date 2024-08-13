class Solution {
    long floorSqrt(long n) {
        // Your code here
        if (n == 1) return 1;

        long low = 1;
        long high = n;
        long result = 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid == n) return mid;

            if (mid * mid < n) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }

        return result;

    }
}
