class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();i++) {
            for(int j=1;j<=text2.length();j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
//     public int lcs(int i, int j, String s1, String s2, int dp[][]) {
//         if(i ==0 || j ==0) return 0;
//         if( dp[i][j] == -1 ) {
            
//             if(s1.charAt(i-1) == s2.charAt(j-1)) {
//                 dp[i][j] = 1 + lcs(i-1, j-1, s1, s2, dp);
//             }
//             else {
//                 dp[i][j] = Math.max(lcs(i-1, j, s1, s2, dp), lcs(i, j-1, s1,s2,dp));
//             }
//         }
//         return dp[i][j];
//     }
}