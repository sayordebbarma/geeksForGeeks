class Solution {
    // Returns count buildings that can see sunlight
    public int countBuildings(int[] height) {
        // code here
        int count = 0;
        int maxHeight = 0;

        for (int h : height) {
            if (h > maxHeight) {
                count++;
                maxHeight = h;
            }
        }

        return count;
    }
}
