class Solution {

    public boolean checkSorted(List<Integer> arr) {
        // code here
        int n = arr.size();
        int swaps = 0;
        
        for (int i = 0; i < n; i++) {
            while (arr.get(i) != i + 1) {
                int correctPos = arr.get(i) - 1;
                
                int temp = arr.get(i);
                arr.set(i, arr.get(correctPos));
                arr.set(correctPos, temp);
        
                swaps++;
        
                if (swaps > 2) return false;
            }
        }
        
        return swaps == 2 || swaps == 0;
    }
}
