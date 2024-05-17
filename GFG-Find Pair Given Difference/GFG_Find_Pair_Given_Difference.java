class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < n; ++i) {
            if (seen.contains(arr[i] - x) || seen.contains(arr[i] + x)) {
                return 1;
            }
            seen.add(arr[i]);
        }

        return -1;
    }
}
