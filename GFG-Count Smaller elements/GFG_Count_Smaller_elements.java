class Solution {
    static class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    int[] constructLowerArray(int[] arr) {
        // code here
        int n = arr.length;
        int[] result = new int[n];
        Element[] elements = new Element[n];

        for (int i = 0; i < n; i++) {
            elements[i] = new Element(arr[i], i);
        }

        mergeSort(elements, result, 0, n - 1);
        return result;
    }

    void mergeSort(Element[] elements, int[] result, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(elements, result, left, mid);
        mergeSort(elements, result, mid + 1, right);
        merge(elements, result, left, mid, right);
    }

    void merge(Element[] elements, int[] result, int left, int mid, int right) {
        Element[] temp = new Element[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (elements[i].value <= elements[j].value) {
                result[elements[i].index] += rightCount;
                temp[k++] = elements[i++];
            } else {
                rightCount++;
                temp[k++] = elements[j++];
            }
        }

        while (i <= mid) {
            result[elements[i].index] += rightCount;
            temp[k++] = elements[i++];
        }

        while (j <= right) {
            temp[k++] = elements[j++];
        }

        System.arraycopy(temp, 0, elements, left, temp.length);
    }
}
