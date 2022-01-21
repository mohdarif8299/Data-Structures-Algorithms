class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1;
        int last = digits[n];
        digits[n] = (digits[n] + 1) % 10;
        int carry = (last + 1) / 10;
        for(int i=n-1;i>=0;i--) {
            last = digits[i];
            digits[i] = (digits[i]+carry)%10;
            carry = (last + carry) / 10;
        }
        
        if(carry == 1) {
            digits = new int[digits.length+1];
            digits[0] = carry;
        }
        
        return digits;
    }
}