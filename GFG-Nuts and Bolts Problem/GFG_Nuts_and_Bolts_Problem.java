class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        matchPairsHelper(nuts, bolts, 0, n - 1);
    }

    private void matchPairsHelper(char[] nuts, char[] bolts, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nuts, low, high, bolts[high]);

            partition(bolts, low, high, nuts[pivotIndex]);

            matchPairsHelper(nuts, bolts, low, pivotIndex - 1);
            matchPairsHelper(nuts, bolts, pivotIndex + 1, high);
        }
    }

    private int partition(char[] array, int low, int high, char pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            } else if (array[j] == pivot) {
                swap(array, j, high);
                j--;
            }
        }
        swap(array, i, high);
        return i;
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
