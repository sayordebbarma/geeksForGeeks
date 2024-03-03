class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        Arrays.sort(arr, (x,y) -> (y+x).compareTo(x+y));
        
        return String.join("", arr);
    }
}
