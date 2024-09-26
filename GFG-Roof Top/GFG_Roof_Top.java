class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        // Your code here
        int c = 0, m = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > arr[i - 1]) {
                ++c;  
            } else {
                m = Math.max(m, c);  
                c = 0;  
            }
        }
        return Math.max(m, c);
    }
}
