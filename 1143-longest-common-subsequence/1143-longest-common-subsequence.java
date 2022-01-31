class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int ar[]: dp) Arrays.fill(ar, -1);
        return lcs(text1.length(), text2.length(), text1, text2, dp);
    }
    public int lcs(int i, int j, String s1, String s2, int dp[][]) {
        if(i ==0 || j ==0) return 0;
        if( dp[i][j] == -1 ) {
            
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                dp[i][j] = 1 + lcs(i-1, j-1, s1, s2, dp);
            }
            else {
                dp[i][j] = Math.max(lcs(i-1, j, s1, s2, dp), lcs(i, j-1, s1,s2,dp));
            }
        }
        return dp[i][j];
    }
}