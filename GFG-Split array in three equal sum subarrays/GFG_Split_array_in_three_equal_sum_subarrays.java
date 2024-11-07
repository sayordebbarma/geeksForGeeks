class Solution {
    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        int n = arr.length;
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 3 != 0) return Arrays.asList(-1, -1);

        int target = totalSum / 3;
        int currentSum = 0;
        int i = -1, j = -1;

        for (int k = 0; k < n; k++) {
            currentSum += arr[k];
            if (currentSum == target) {
                i = k;
                break;
            }
        }

        if (i == -1) return Arrays.asList(-1, -1);

        currentSum = 0;

        for (int k = i + 1; k < n; k++) {
            currentSum += arr[k];
            if (currentSum == target) {
                j = k;
                break;
            }
        }

        if (j == -1 || j == n - 1) return Arrays.asList(-1, -1);

        currentSum = 0;
        for (int k = j + 1; k < n; k++) {
            currentSum += arr[k];
        }

        if (currentSum == target) return Arrays.asList(i, j);

        return Arrays.asList(-1, -1);
    }
}
