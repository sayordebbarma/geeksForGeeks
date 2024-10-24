class Solution {
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] = 2 * arr[i];
                arr[i + 1] = 0;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) result.add(arr[i]);
        }
        
        while (result.size() < n) {
            result.add(0);
        }
        
        return result;
    }
}
