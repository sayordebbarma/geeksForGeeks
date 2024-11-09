class Solution {
    String minSum(int[] arr) {
        // code here
        int length = arr.length;
        Arrays.sort(arr);
        
        StringBuilder firstNum = new StringBuilder();
        StringBuilder secondNum = new StringBuilder();

        for (int idx = 0; idx < length; idx++) {
            if (idx % 2 == 0) firstNum.append(arr[idx]);
            else secondNum.append(arr[idx]);
        }

        int len1 = firstNum.length();
        int len2 = secondNum.length();
        
        String num1Str = firstNum.toString();
        String num2Str = secondNum.toString();
        
        int ptr1 = len1 - 1, ptr2 = len2 - 1;
        int carryOver = 0;
        StringBuilder result = new StringBuilder();

        while (ptr1 >= 0 || ptr2 >= 0 || carryOver != 0) {
            int digit1 = ptr1 >= 0 ? num1Str.charAt(ptr1) - '0' : 0;
            int digit2 = ptr2 >= 0 ? num2Str.charAt(ptr2) - '0' : 0;
            
            int sum = digit1 + digit2 + carryOver;
            result.append(sum % 10);
            carryOver = sum / 10;
            
            ptr1--;
            ptr2--;
        }

        result.reverse();
        int startIdx = 0;
        while (startIdx < result.length() && result.charAt(startIdx) == '0') {
            startIdx++;
        }
        
        return result.substring(startIdx);
    }
}
