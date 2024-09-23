class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int n = arr.length;

        long sumN = (long) n * (n + 1) / 2;
        long sumNSq = (long) n * (n + 1) * (2 * n + 1) / 6;

        long sumArr = 0, sumArrSq = 0;
        for (int i = 0; i < n; i++) {
            sumArr += arr[i];
            sumArrSq += (long) arr[i] * arr[i];
        }

        long diff = sumArr - sumN;
        long sumDiffSq = sumArrSq - sumNSq;

        long sum = sumDiffSq / diff;

        int missing = (int) (sum - diff) / 2;
        int repeating = (int) (sum + diff) / 2;

        return new int[]{repeating, missing};
    }
}
