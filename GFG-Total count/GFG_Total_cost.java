class Solution {
    int totalCount(int k, int[] arr) {
        // code here
        int totalParts = 0;

        for (int num : arr) {
            totalParts += (num + k - 1) / k;
        }

        return totalParts;
    }
}
