class Solution {
    static boolean canPlaceStations(int[] stations, double mid, int k) {
        int additionalStationsNeeded = 0;
        for (int i = 1; i < stations.length; i++) {
            int gap = stations[i] - stations[i - 1];
            additionalStationsNeeded += Math.ceil(gap / mid) - 1;
        }
        return additionalStationsNeeded <= k;
    }

    public static double findSmallestMaxDist(int[] stations, int k) {
        //code here
        int n = stations.length;
        double low = 0;
        double high = stations[n - 1] - stations[0];
        double mid = 0;
        double result = high;

        while (high - low > 1e-6) {
            mid = (low + high) / 2.0;
            if (canPlaceStations(stations, mid, k)) {
                result = mid;
                high = mid;
            } else {
                low = mid;
            }
        }

        return Math.round(result * 100.0) / 100.0;
    }
}
