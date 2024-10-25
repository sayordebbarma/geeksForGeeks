class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        // Your code goes here
        Arrays.sort(arr);

        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if (left <= right) result.add(arr[right--]);

            if (left <= right) result.add(arr[left++]);
        }

        return result;
    }
}
