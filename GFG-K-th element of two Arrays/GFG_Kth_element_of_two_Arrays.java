class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        return kth(arr1, arr2, 0, arr1.length, 0, arr2.length, k - 1);
    }

    private long kth(int[] arr1, int[] arr2, int s1, int e1, int s2, int e2, int k) {
        if (s1 >= e1) return arr2[s2 + k];
        if (s2 >= e2) return arr1[s1 + k];
        
        int mid1 = (e1 - s1) / 2;
        int mid2 = (e2 - s2) / 2;
        
        if (mid1 + mid2 < k) {
            if (arr1[s1 + mid1] > arr2[s2 + mid2]) {
                return kth(arr1, arr2, s1, e1, s2 + mid2 + 1, e2, k - mid2 - 1);
            } else {
                return kth(arr1, arr2, s1 + mid1 + 1, e1, s2, e2, k - mid1 - 1);
            }
        } else {
            if (arr1[s1 + mid1] > arr2[s2 + mid2]) {
                return kth(arr1, arr2, s1, s1 + mid1, s2, e2, k);
            } else {
                return kth(arr1, arr2, s1, e1, s2, s2 + mid2, k);
            }
        }
    }
}
