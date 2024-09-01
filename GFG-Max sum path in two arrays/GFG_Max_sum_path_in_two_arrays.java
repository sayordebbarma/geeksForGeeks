class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int m = arr1.size(), n = arr2.size();
        int i = 0, j = 0;
        int result = 0, sum1 = 0, sum2 = 0;

        while (i < m && j < n) {
            if (arr1.get(i) < arr2.get(j)) {
                sum1 += arr1.get(i++);
            } else if (arr1.get(i) > arr2.get(j)) {
                sum2 += arr2.get(j++);
            } else { // arr1.get(i) == arr2.get(j)
                result += Math.max(sum1, sum2) + arr1.get(i);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }

        while (i < m) {
            sum1 += arr1.get(i++);
        }

        while (j < n) {
            sum2 += arr2.get(j++);
        }

        result += Math.max(sum1, sum2);
        return result;
    }
}
