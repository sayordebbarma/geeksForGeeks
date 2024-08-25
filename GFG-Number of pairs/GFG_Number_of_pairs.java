class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
        int[] count = new int[1001];
        for (int num : y) count[num]++;

        Arrays.sort(y);
        long totalPairs = 0;

        for (int num : x) {
            if (num == 0) continue;
            if (num == 1) {
                totalPairs += count[0];
                continue;
            }

            int index = upperBound(y, num);
            totalPairs += N - index + count[0] + count[1];
            if (num == 2) totalPairs -= count[3] + count[4];
            if (num == 3) totalPairs += count[2];
        }

        return totalPairs;
    }

    private int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
