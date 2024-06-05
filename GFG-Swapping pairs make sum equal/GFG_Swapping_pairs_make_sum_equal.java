class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        long sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            sumA += a[i];
        }
        for (int i = 0; i < m; i++) {
            sumB += b[i];
        }

        long diff = sumA - sumB;

        if ((diff & 1) != 0) return -1;

        long target = diff / 2;

        Set<Long> setA = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(a[i]);
        }

        for (int i = 0; i < m; i++) {
            if (setA.contains(b[i] + target)) return 1;
        }

        return -1;
    }
}
