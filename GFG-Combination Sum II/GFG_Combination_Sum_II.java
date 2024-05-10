class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        backtrack(result, new ArrayList<>(), arr, k, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] arr, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) result.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < arr.length; i++) {
                if (i > start && arr[i] == arr[i - 1]) continue;
                tempList.add(arr[i]); 
                backtrack(result, tempList, arr, remain - arr[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
