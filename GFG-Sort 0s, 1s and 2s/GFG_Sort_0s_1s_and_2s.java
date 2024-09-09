class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int low = 0, mid = 0, high = arr.size() - 1;

        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    int temp0 = arr.get(low);
                    arr.set(low, arr.get(mid));
                    arr.set(mid, temp0);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    int temp2 = arr.get(mid);
                    arr.set(mid, arr.get(high));
                    arr.set(high, temp2);
                    high--;
                    break;
            }
        }
    }
}
