class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int left = 0, right = 0;
        int n = arr.length;

        while (right < n) {
            if (arr[right] == 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
    }
}
