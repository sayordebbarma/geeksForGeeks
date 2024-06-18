class Solution {
    int rectanglesInCircle(int r) {
        // code here
        int count = 0;
        int maxSide = 2 * r;

        for (int l = 1; l <= maxSide; l++) {
            for (int w = 1; w <= maxSide; w++) {
                if (l * l + w * w <= 4 * r * r) count++;
            }
        }

        return count;
    }
};
