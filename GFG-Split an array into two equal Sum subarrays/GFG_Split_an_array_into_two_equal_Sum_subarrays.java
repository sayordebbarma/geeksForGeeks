class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int prefixSum = 0;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum == target) return true;
        }

        return false;
    }
}
