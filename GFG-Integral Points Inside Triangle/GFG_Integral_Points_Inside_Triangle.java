class Solution {
    long InternalCount(long p[], long q[], long r[]) {
        // code here
        long area = Math.abs(p[0] * (q[1] - r[1]) + q[0] * (r[1] - p[1]) + r[0] * (p[1] - q[1]));

        long B = boundaryPoints(p[0], p[1], q[0], q[1]) +
                 boundaryPoints(q[0], q[1], r[0], r[1]) +
                 boundaryPoints(r[0], r[1], p[0], p[1]) - 3;

        long I = (area - B + 2) / 2;

        return I;

    }
    
     long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    long boundaryPoints(long x1, long y1, long x2, long y2) {
        return gcd(Math.abs(x2 - x1), Math.abs(y2 - y1)) + 1;
    }

};
