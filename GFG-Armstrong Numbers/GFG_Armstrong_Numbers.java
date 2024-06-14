class Solution {
    static String armstrongNumber(int n) {
        // code here
        int original = n;
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 3);
            n /= 10;
        }
        return sum == original ? "true" : "false";

    }
}
