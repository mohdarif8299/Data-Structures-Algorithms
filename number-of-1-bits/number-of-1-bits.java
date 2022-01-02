public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i=31;i>=0 ;i--) {
            if((n & mask) != 0) {
                count += 1;
            }
            mask <<= 1;
        }
        return count;
    }
}