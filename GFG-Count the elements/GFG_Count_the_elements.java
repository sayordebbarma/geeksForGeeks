class Solution
{
    public static int[] countElements(int a[], int b[], int n, int query[], int q)
    {
        Arrays.sort(b);

        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int count = 0;
            int index = query[i];
            int target = a[index];

            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (b[mid] <= target) {
                    count = mid + 1;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            result[i] = count;
        }

        return result;

    }
}
