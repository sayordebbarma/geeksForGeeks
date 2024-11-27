class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        int n = arr.length;
        int shift = segregate(arr, n);

        int[] positiveArr = new int[n - shift];
        for (int i = 0; i < positiveArr.length; i++) {
            positiveArr[i] = arr[shift + i];
        }

        for (int i = 0; i < positiveArr.length; i++) {
            int absVal = Math.abs(positiveArr[i]);
            if (absVal - 1 < positiveArr.length && positiveArr[absVal - 1] > 0) positiveArr[absVal - 1] = -positiveArr[absVal - 1];
        }

        for (int i = 0; i < positiveArr.length; i++) {
            if (positiveArr[i] > 0) return i + 1;
        }

        return positiveArr.length + 1;
    }

    private int segregate(int[] arr, int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j;
    }
}
