class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return countWays(0, s, dp);
    }
    public int countWays(int i, String s, int dp[]) {
        if(i > s.length()) return 0;
        if(i == s.length()) return 1;
        if(s.charAt(i) - '0' == 0) return 0;
        
        int x=0,y=0;
        
        if(dp[i] == -1) {
            x = countWays(i+1, s, dp);

            if( i+1 < s.length()) {
                int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i+1)-'0');
                if(twoDigit <= 26 && twoDigit >= 10)
                    y = countWays(i+2, s, dp);
            }
            dp[i] = x+y;
        }
        return dp[i];
    }
}