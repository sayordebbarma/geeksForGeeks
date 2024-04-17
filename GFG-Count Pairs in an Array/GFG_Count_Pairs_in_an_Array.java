class Solution {  
    static int countPairs(int arr[], int n) 
    {
         // Your code goes here
        for (int i = 0; i < n; i++) {
            arr[i] = i * arr[i];
        }
        return countInversions(arr, 0, n - 1);
    }

    static int countInversions(int[] arr, int l, int r) {
        int count = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            count += countInversions(arr, l, mid);
            count += countInversions(arr, mid + 1, r);
            count += mergeAndCount(arr, l, mid, r);
        }
        return count;
    }

    static int mergeAndCount(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int count = 0, i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (n1 - i);
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }

        return count;
    }
}
