class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        long memo[][] = new long[n + 1][n + 1];
        for (long x[] : memo) {
            Arrays.fill(x, -2);
        }
        return maximizeDP(0, n - 1, arr, memo);
    }
    
    static long maximizeDP(int start, int end, int arr[], long memo[][]) {
        if (start > end) return 0;
        if (start == end) return arr[start];
    
        if (memo[start][end] != -2) return memo[start][end];
    
        long pickFirst = arr[start] + Math.min(maximizeDP(start + 2, end, arr, memo),
                maximizeDP(start + 1, end - 1, arr, memo));
    
        long pickLast = arr[end] + Math.min(maximizeDP(start, end - 2, arr, memo),
                maximizeDP(start + 1, end - 1, arr, memo));
    
        return memo[start][end] = Math.max(pickFirst, pickLast);
    }
}
