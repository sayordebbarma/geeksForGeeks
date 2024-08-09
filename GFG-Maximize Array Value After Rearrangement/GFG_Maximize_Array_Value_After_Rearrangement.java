class Solution {

    int Maximize(int arr[]) {
        // Complete the function
        int n = arr.length;
        long mod = 1000000007;
        long result = 0;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * i) % mod;
        }

        return (int) result;
    }
}
