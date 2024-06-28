class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            if (isPalindrome(arr[i])) return i + " R";
        }
        
        for (int j = 0; j < n; j++) {
            if (isPalindromeColumn(arr, j)) return j + " C";
        }
        
        return "-1";
    }
    
    private static boolean isPalindrome(int[] array) {
        int start = 0, end = array.length - 1;
        while (start < end) {
            if (array[start] != array[end]) return false;

            start++;
            end--;
        }
        return true;
    }
    
    private static boolean isPalindromeColumn(int[][] arr, int col) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start][col] != arr[end][col]) return false;
            
            start++;
            end--;
        }
        return true;

    }
}
