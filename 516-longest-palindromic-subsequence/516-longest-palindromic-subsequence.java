class Solution {
    public int longestPalindromeSubseq(String s) {
     int dp[][] = new int[s.length()][s.length()];
        return lps(0, s.length()-1, s, dp);
    }
    public int lps(int i, int j, String s, int dp[][]) {
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j] == 0) {
            if(s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 2 + lps(i+1, j-1, s, dp);
            } else {
                dp[i][j] = Math.max(lps(i+1, j, s, dp), lps(i, j-1, s, dp));
            }
        }
        return dp[i][j];
    }
}