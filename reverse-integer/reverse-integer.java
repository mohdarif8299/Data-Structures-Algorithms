class Solution {
    public int reverse(int x) {
        int num = x;
        long reverse = 0;
        num = Math.abs(num);
        while(num > 0) {
            int digit = num%10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        if(reverse  > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;
        if(x < 0) return -(int)reverse;
        return (int)reverse;
    }
}