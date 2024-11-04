class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        List<List<Integer>> result = new ArrayList<>();
        int length = arr.length;
        
        Map<Integer, List<int[]>> pairSumMap = new HashMap<>();
        
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int currentSum = arr[i] + arr[j];
                pairSumMap
                    .computeIfAbsent(currentSum, k -> new ArrayList<>())
                    .add(new int[]{i, j});
            }
        }
        
        for (int k = 0; k < length; k++) {
            int target = -arr[k];
            if (pairSumMap.containsKey(target)) {
                for (int[] indices : pairSumMap.get(target)) {
                    if (indices[0] < k && indices[1] < k) {
                        result.add(Arrays.asList(indices[0], indices[1], k));
                    }
                }
            }
        }
        
        return result;
    }
}
