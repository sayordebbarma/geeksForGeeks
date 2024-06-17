class Solution {
    private int findOrientation(int[] p, int[] q, int[] r) {
        long value = (long) (q[1] - p[1]) * (r[0] - q[0]) - (long) (r[1] - q[1]) * (q[0] - p[0]);
        if (value == 0) return 0;
        return (value > 0) ? 1 : 2;
    }

    private boolean isOnSegment(int[] a, int[] b, int[] c) {
        return (c[0] >= Math.min(a[0], b[0]) && c[0] <= Math.max(a[0], b[0]) &&
                c[1] >= Math.min(a[1], b[1]) && c[1] <= Math.max(a[1], b[1]));
    }
    
    String doIntersect(int p1[], int q1[], int p2[], int q2[]) {
        // code here
        int o1 = findOrientation(p1, q1, p2);
        int o2 = findOrientation(p1, q1, q2);
        int o3 = findOrientation(p2, q2, p1);
        int o4 = findOrientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) return "true";

        if (o1 == 0 && isOnSegment(p1, q1, p2)) return "true";
        if (o2 == 0 && isOnSegment(p1, q1, q2)) return "true";
        if (o3 == 0 && isOnSegment(p2, q2, p1)) return "true";
        if (o4 == 0 && isOnSegment(p2, q2, q1)) return "true";

        return "false";
    }
}
