class Solution {
    static Long reversedBits(Long x) {
        // code here
        long reversed = 0L;
        int bitCount = 32;
        
        for (int i = 0; i < bitCount; i++) {
            reversed |= (x & 1L) << (bitCount - 1 - i);

            x >>= 1;
        }
        
        return reversed;
    }
}
