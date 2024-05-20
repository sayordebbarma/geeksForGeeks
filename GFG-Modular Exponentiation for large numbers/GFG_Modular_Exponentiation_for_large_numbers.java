class Solution
{
    public long PowMod(long x, long n, long m)
    {
        // Code here
        if (n == 0) return 1; 

        x %= m;
        long half = PowMod(x, n / 2, m);

        if (n % 2 == 0) return (half * half) % m;
        else return (((half * half) % m) * x) % m;

    }
}
