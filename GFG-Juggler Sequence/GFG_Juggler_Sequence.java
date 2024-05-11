class Solution {
    static List<Long> jugglerSequence(long n) {
        // code here
        List<Long> sequence = new ArrayList<>();
        
        while (n != 1) {
            sequence.add(n);
            n = (n % 2 == 1) ? (long) Math.pow(Math.sqrt(n), 3) : (long) Math.sqrt(n);
        }
        
        sequence.add(1L);
        return sequence;
    }
}
