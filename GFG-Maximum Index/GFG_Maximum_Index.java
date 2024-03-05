class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        int right[] = new int[n];
        int left[] = new int[n];
        left[0] = a[0];
        right[n-1] = a[n-1];
        
        for(int i=1; i<n; i++) left[i] = Math.min(a[i], left[i-1]);
        for(int j=n-2; j>=0; j--) right[j] = Math.max(a[j], right[j+1]);
        
        int i = 0;
        int j = 0;
        int result = Integer.MIN_VALUE;
        
        while(j<n && i<n) {
            if(left[i]<=right[j]) {
                result = Math.max(result, j-i);
                j++;
            } else {
                i++;
            }
        }
        
        return result;

    }
}
