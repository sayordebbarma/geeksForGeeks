class Solution {
    long max_sum(int a[], int n) {
        // Your code here
        long current_value = 0;
        long array_sum = 0;
        for (int i = 0; i < n; i++) {
            current_value += i * (long) a[i];
            array_sum += (long) a[i];
        }
        
        long max_value = current_value;
        
        for (int i = 1; i < n; i++) {
            current_value = current_value - array_sum + n * (long) a[i - 1];
            max_value = Math.max(max_value, current_value);
        }
        
        return max_value;
    }
}
