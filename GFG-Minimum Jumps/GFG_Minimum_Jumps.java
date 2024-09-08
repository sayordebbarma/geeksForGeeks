class Solution {
    static int minJumps(int[] arr) {
        // your code here
        if (arr.length <= 1) return 0;
        if (arr[0] == 0) return -1;

        int maxReach = arr[0], steps = arr[0], jumps = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jumps;
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }
        
        return -1;
    }
}
