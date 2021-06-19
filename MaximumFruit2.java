public class Solution {
    public int solve(int[] A, int B) {
           long dp[] = new long[A.length];
           Arrays.fill(dp,-1);
           long ans = maximumFruit(A.length-1,A,B,dp);
           if(ans<0) return 0;
           return (int)(ans%1000000007);
    }a
    public static long maximumFruit(int i,int A[],int B,long[] dp) {
        if(i<0) return 0;
        if(i==0) return A[0]>0?A[0]:0;
        if(dp[i]!=-1) return dp[i];
            dp[i] = Math.max(A[i]+maximumFruit(i-1-B,A,B,dp),maximumFruit(i-1,A,B,dp));
        return dp[i];
    }
}
