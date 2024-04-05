class Solution
{
    public int min_operations(int []nums)
    {
        // Code here
        int n = nums.length;
        int[] lis = new int[n];
        lis[0] = 1;
        int res = lis[0];
        
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && nums[i] - nums[j] > i - j - 1) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            res = Math.max(res, lis[i]);
        }
        
        return n - res;
    }
}
