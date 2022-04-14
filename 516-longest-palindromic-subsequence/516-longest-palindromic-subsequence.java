class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        return lps(0, s.length()-1, s, dp);
    }
    public int lps(int first, int last,String s, int dp[][]) {
        if(first == last) return 1;
        if(first > last) return 0;
        if(dp[first][last] == -1) {
        
            if(s.charAt(first) == s.charAt(last)) {
                dp[first][last] = lps(first+1,last-1, s, dp) + 2;
            } else {
                dp[first][last] = Math.max(lps(first+1, last, s, dp), lps(first, last-1, s, dp));
            }
        }
        return dp[first][last];
    }
}