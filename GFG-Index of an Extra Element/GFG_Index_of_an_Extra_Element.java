class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        int left = 0;
        int right = arr1.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == arr2.length || arr1[mid] != arr2[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
}
