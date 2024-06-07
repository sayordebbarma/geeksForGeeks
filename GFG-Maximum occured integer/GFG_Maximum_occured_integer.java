class Solution {
    // Function to find the maximum occurred integer in all ranges.
    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] diff = new int[maxx + 2];

        for (int i = 0; i < l.length; i++) {
            diff[l[i]] += 1;
            if (r[i] + 1 <= maxx) diff[r[i] + 1] -= 1;
        }

        int maxCount = diff[0];
        int maxInteger = 0;
        int currentCount = diff[0];
        
        for (int i = 1; i <= maxx; i++) {
            currentCount += diff[i];
            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxInteger = i;
            }
        }

        return maxInteger;
    }
}
