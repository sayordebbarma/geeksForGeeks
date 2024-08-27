class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int maxDiff = 0;
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            l[i] = s.isEmpty() ? 0 : arr[s.peek()];
            s.push(i);
        }
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            r[i] = s.isEmpty() ? 0 : arr[s.peek()];
            s.push(i);
        }
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(l[i] - r[i]));
        }

        return maxDiff;
    }
}
