class Solution {
    long sumBitDifferences(int[] arr, int n) {
        // code here
        long result=0;
        
        for(int i=0; i<32; i++) {
            long count=0;
            for(int j=0; j<n;j++) {
                if((arr[j]&(1<<i)) != 0) count++;
            }
            result += count*(n-count)*2;
        }
        
        return result;
    }
}
