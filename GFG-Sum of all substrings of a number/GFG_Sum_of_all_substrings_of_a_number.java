class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
    long sum = 0, prevSum = 0, mod = 1000000007;
    for(int i = 0; i < s.length(); i++) {
        long currentSum = (prevSum * 10) % mod + (s.charAt(i) - '0') * (i + 1) % mod;
        prevSum = currentSum;
        sum = (sum + currentSum) % mod;
    }
    return sum;
    }
}
