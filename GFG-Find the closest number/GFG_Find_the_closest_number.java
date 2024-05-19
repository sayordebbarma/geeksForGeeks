class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        // code here
        int r = Arrays.binarySearch(arr, k);
        if (r < 0) {
            r = -r - 1;
        }
        int l = r - 1;
        if (r >= n) {
            return arr[l];
        }
        if (l < 0) {
            return arr[r];
        } else {
            int diff1 = Math.abs(k - arr[r]);
            int diff2 = Math.abs(k - arr[l]);
            if (diff1 <= diff2) {
                return arr[r];
            }
            return arr[l];
        }
    }
}
