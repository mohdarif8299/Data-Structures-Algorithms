class Solution {
    public double myPow(double x, int n) {
        double d = 1;
        long temp = n;
        if(n < 0) {
            temp = -1*temp;
        }
        while(temp > 0) {
            if((temp&1) != 0) {
                d *= x;
            }
            x *= x;
            temp >>= 1;
        }
        if(n < 0) d =  1/d;
        return d;
    }
}