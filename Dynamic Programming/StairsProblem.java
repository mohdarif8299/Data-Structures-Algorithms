public class Solution {
    public int climbStairs(int A) {
       if(A<=2) return A;
       int dp[] = new int[A+1];
       Arrays.fill(dp,-1);
       dp[0]=0;
       dp[1]=1;
       dp[2]=2;
       return stairs(A,dp);
    }
    public static int stairs(int N,int dp[]) {
        if(N<=2) return dp[N];
        if(dp[N]!=-1)  return dp[N];
        dp[N] = stairs(N-1,dp)+stairs(N-2,dp);
        return dp[N];
    }
}
