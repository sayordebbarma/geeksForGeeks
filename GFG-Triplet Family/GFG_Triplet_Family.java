class Solution {
    public boolean findTriplet(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); 
        
        for (int k = 2; k < n; k++) {
            int i = 0;
            int j = k - 1;
            
            while (i < j) {
                int sum = arr[i] + arr[j];
                
                if (sum == arr[k]) return true;
                else if (sum < arr[k]) i++;
                else j--;
            }
        }
        
        return false;
    }
}
