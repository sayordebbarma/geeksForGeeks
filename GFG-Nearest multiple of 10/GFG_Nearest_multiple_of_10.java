class Solution {

    String roundToNearest(String str) {
        // Complete the function
        int lastIndex = str.length() - 1;
        char[] digits = str.toCharArray();

        if (digits[lastIndex] <= '5') {
            digits[lastIndex] = '0';
            return String.valueOf(digits);
        }

        digits[lastIndex] = '0';
        lastIndex--;

        while (lastIndex >= 0 && digits[lastIndex] == '9') {
            digits[lastIndex] = '0';
            lastIndex--;
        }

        if (lastIndex == -1) {
            return "1" + String.valueOf(digits);
        }

        digits[lastIndex]++;
        return String.valueOf(digits);
    }
}
