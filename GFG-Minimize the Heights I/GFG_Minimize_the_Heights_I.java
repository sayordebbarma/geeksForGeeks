class Solution {
    public int getMinDiff(int k, int[] arr) {
        // code here
        int n = arr.length;
        if (n == 1) return 0;
        Arrays.sort(arr);

        int minDiff = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            int maxHeight = Math.max(largest, arr[i] + k);
            int minHeight = Math.min(smallest, arr[i + 1] - k);

            minDiff = Math.min(minDiff, maxHeight - minHeight);
        }

        return minDiff;
    }
}
