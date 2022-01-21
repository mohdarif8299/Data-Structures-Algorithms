class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length-1;
        int last = digits[n];
        int carry = 1;
        for(int i=n;i>=0;i--) {
            last = digits[i];
            digits[i] = (digits[i] + carry) % 10;
            carry = (last + carry) / 10;
        }
        
        if(carry == 1) {
            digits = new int[digits.length+1];
            digits[0] = carry;
        }
        
        return digits;
    }
}