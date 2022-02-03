class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        for(int arr[]: dp)
            Arrays.fill(arr, -1);
        return distinct(0, 0,s, t, dp);
    }
    public int distinct(int i, int j, String s, String t, int dp[][]) {
        if(j == t.length())  return 1;
        if(i == s.length()) return 0;
        if( dp[i][j] == -1) {
            if(s.charAt(i) == t.charAt(j)) {
                dp[i][j] = distinct(i+1, j+1, s, t, dp) + distinct(i+1, j, s, t, dp);
            } else {
                dp[i][j] = distinct(i+1, j, s, t, dp);
            }
        }
        return dp[i][j];
    }
}