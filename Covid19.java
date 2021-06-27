public class Solution {
    public static int MOD = 1000000007;
    public int calculateCells(int A, int B, int C) {
        int dp[] = new int[A];
        dp[0]=1;
        for(int i=1;i<A;i++) {
            dp[i]=dp[i-1];
            if(i-B>=0)
            dp[i] = (dp[i]+dp[i-B])%MOD;
            if(i-C>=0) 
            dp[i] = ((dp[i]-dp[i-C])+MOD)%MOD;
        }
        return dp[A-1];
    }
}
