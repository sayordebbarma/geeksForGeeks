class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int max = 1000000;

        int[] frequency = new int[max + 1];

        for (int num : arr) {
            frequency[num]++;
        }

        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (frequency[i] > 0) {
                count += frequency[i];
                if (count >= k) return i;
            }
        }
        return -1;
    }
}
