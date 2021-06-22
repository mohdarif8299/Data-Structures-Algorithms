public class Solution {
    public int solve(String A) {
        int N = A.length();
      int dp[][] = new int[N][N];
      for(int i=0;i<N;i++) {
          for(int j=0;j<N;j++) {
              dp[i][j]=-1;
          }
      }
      return lps(0,N-1,A,dp);
    }
    public static int lps(int i,int j,String S,int dp[][]) {
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(S.charAt(i)==S.charAt(j)) {
            dp[i][j] = 2+lps(i+1,j-1,S,dp);
        } else {
            dp[i][j] =  Math.max(lps(i+1,j,S,dp),lps(i,j-1,S,dp));
        }
        return dp[i][j];
        
    }
}
