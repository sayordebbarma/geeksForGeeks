class Solution {
    public int minIncrements(int[] arr) {
        // Code here
        Arrays.sort(arr);
        int increments = 0;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                int neededIncrement = arr[i - 1] - arr[i] + 1;
                arr[i] += neededIncrement;
                increments += neededIncrement;
            }
        }
        
        return increments;
    }
}
