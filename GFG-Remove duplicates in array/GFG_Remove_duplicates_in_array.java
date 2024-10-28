class Solution {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
        boolean[] seen = new boolean[101];
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (!seen[num]) {
                seen[num] = true;
                result.add(num);
            }
        }

        return result;
    }
}
