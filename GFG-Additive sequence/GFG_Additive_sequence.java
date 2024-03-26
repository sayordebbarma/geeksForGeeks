class Solution {
    public boolean isAdditiveSequence(String n) {  
        // code here
        for (int i = 0; i < n.length() / 2; i++) {
            for (int j = i + 1; j < n.length() - 1; j++) {
                String firstNum = n.substring(0, i + 1);
                String secondNum = n.substring(i + 1, j + 1);
                String remainingNum = n.substring(j + 1);
                if (checkAdditive(firstNum, secondNum, remainingNum)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static String calculateSum(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            result.append((char) (sum % 10 + '0'));
            carry = sum / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = (num1.charAt(i) - '0') + carry;
            result.append((char) (sum % 10 + '0'));
            carry = sum / 10;
            i--;
        }
        while (j >= 0) {
            int sum = (num2.charAt(j) - '0') + carry;
            result.append((char) (sum % 10 + '0'));
            carry = sum / 10;
            j--;
        }
        if (carry != 0) {
            result.append((char) (carry + '0'));
        }
        return result.reverse().toString();
    }
    
    static boolean checkAdditive(String first, String second, String remaining) {
        String sum = calculateSum(first, second);
        int i = 0, j = 0;
        while (i < remaining.length() && j < sum.length()) {
            if (remaining.charAt(i) != sum.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        if (j != sum.length()) {
            return false;
        }
        if (i == remaining.length()) {
            return true;
        }
        remaining = remaining.substring(i);
        return checkAdditive(second, sum, remaining);
    }
}
