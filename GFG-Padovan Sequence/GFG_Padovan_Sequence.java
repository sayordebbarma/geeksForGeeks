class Solution
{
    private static final int MOD = 1000000007;
    
    public int padovanSequence(int n)
    {
        //code here.
        if (n == 0 || n == 1 || n == 2) return 1;

        long p0 = 1, p1 = 1, p2 = 1;
        long pN = 0;
    
        for (int i = 3; i <= n; i++) {
          pN = (p1 + p0) % MOD;
          p0 = p1;
          p1 = p2;
          p2 = pN;
        }
    
        return (int) pN;
    }
}
