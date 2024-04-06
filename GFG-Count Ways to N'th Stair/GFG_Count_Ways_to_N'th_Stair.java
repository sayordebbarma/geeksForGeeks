class Solution {
    // Function to count number of ways to reach the nth stair
    // when order does not matter.
    Long countWays(int n) {
        // your code here
        long ways = n/ 2 + 1;
        
        return ways;
    }
}
