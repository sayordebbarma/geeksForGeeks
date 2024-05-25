class Solution {
    long max_Books(int arr[], int n, int k) {
        // Your code here
        long max_books = 0;
        long current_books = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) {
                current_books = 0;
            } else {
                current_books += arr[i];
                max_books = Math.max(max_books, current_books);
            }
        }
        
        return max_books;
    }
}
