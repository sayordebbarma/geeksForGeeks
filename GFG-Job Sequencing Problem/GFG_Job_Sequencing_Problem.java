class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        int maxDeadline = 0;
        for (Job job : arr) {
            if (job.deadline > maxDeadline) maxDeadline = job.deadline;
        }
        
        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1);
        
        int jobCount = 0;
        int maxProfit = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = arr[i].id;
                    jobCount++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        return new int[] { jobCount, maxProfit };
    }
}
