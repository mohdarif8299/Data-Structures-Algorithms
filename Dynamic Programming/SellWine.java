public class Solution {
    public int solve(int[] A) {
       int N = A.length;
       int dp[][] = new int[N][N];
       for(int i=0;i<N;i++) {
           for(int j=0;j<N;j++) {
               dp[i][j]=-1;
           }
       }
       return maxProfit(0,N-1,A,dp,N);
    }
    public static int maxProfit(int i,int j,int A[],int dp[][],int N) {
        if(i==j) return N*A[i];
        if(dp[i][j]!=-1) return dp[i][j];
        int year = N-(j-i);
        int x = A[i]*year+maxProfit(i+1,j,A,dp,N);
        int y = A[j]*year+maxProfit(i,j-1,A,dp,N);
        dp[i][j] = Math.max(x,y);
        return dp[i][j];
        
    }
}
