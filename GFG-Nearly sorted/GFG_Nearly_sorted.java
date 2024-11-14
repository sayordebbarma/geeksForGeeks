class Solution {
    // Non-static method, so you need to call it on an instance of the class
    public void nearlySorted(int[] arr, int k) {
        // code
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int i = 0;
        for (; i <= k && i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        int index = 0;
        for (; i < arr.length; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
