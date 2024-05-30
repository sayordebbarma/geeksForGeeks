class Solution {
    static int swapNibbles(int n) {
        // code here
        int lowerNibble = (n & 0x0F) << 4;
        int higherNibble = (n & 0xF0) >> 4;

        return lowerNibble | higherNibble;
    }
}
