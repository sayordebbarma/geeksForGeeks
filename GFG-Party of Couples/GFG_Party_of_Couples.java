class Solution{
    static int findSingle(int n, int arr[]){
        // code here
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
