class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        boolean[] isPrime = new boolean[n + 1];
        
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (isPrime[i] && isPrime[n - i]) {
                result.add(i);
                result.add(n - i);
                return result;
            }
        }
        
        result.add(-1);
        result.add(-1);
        return result;
    }
}
