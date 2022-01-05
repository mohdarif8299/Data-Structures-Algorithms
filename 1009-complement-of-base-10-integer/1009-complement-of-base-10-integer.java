class Solution {
    public int bitwiseComplement(int n) {
        int num = 0;
        int mask = 1;
        int bits = bits(n);
        if(bits == 0) return 1;
        for(int i=bits-1;i>=0;i--) {
            if((n&(1<<i)) == 0) {
                num += (int)Math.pow(2, i);
            }
        }
        return num;
    }
    public int bits(int n) {
        int count = 0;
        while(n > 0) {
            count++;
            n /= 2;
        }
        return count;
    }
}