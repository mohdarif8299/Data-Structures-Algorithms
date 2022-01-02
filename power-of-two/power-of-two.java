class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        StringBuilder sb = new StringBuilder("");
        while(n > 0) {
            sb.append(n%2);
            n /= 2;
        }
        sb.reverse();
        for(int i=1;i<sb.length();i++) {
            if(sb.charAt(i) == '1') return false;
        }
        return true;
    }
}