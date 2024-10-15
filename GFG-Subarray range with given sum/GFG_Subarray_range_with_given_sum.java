class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // add your code here
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int cumSum = 0;
        int count = 0;
        
        prefixSumMap.put(0, 1);
        
        for (int num : arr) {
            cumSum += num;
            
            if (prefixSumMap.containsKey(cumSum - tar)) {
                count += prefixSumMap.get(cumSum - tar);
            }
            
            prefixSumMap.put(cumSum, prefixSumMap.getOrDefault(cumSum, 0) + 1);
        }
        
        return count;
    }
}
