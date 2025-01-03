class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c1 = 0, c2 = 0, n = nums.length;
    
        for (int num : nums) {
            if (num == a) c1++;
            else if (num == b) c2++;
            else if (c1 == 0) { a = num; c1 = 1; }
            else if (c2 == 0) { b = num; c2 = 1; }
            else { c1--; c2--; }
        }
    
        c1 = 0; c2 = 0;
        for (int num : nums) {
            if (num == a) c1++;
            else if (num == b) c2++;
        }
    
        List<Integer> ans = new ArrayList<>();
        if (c1 > n / 3) ans.add(a);
        if (c2 > n / 3) ans.add(b);
    
        Collections.sort(ans);
        return ans;
    }
}
