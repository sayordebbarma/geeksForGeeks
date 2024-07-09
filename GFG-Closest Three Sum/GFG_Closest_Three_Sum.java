class Solution {
    static int threeSumClosest(int[] array, int target) {
        // code here
        Arrays.sort(array);
        int n = array.length;
        int closestSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];

                if (Math.abs(target - currentSum) < Math.abs(target - closestSum) ||
                    (Math.abs(target - currentSum) == Math.abs(target - closestSum) && currentSum > closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum < target) left++;
                else if (currentSum > target) right--;
                else return currentSum;
            }
        }

        return closestSum;
    }
}
