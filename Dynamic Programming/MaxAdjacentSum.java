public class Solution {
    public int adjacent(int[][] A) {
        int P[] = new int[A[0].length];
        for(int j=0;j<A[0].length;j++) 
                 P[j] = Math.max(A[0][j],A[1][j]);
        int dp[] = new int[P.length];
        Arrays.fill(dp,-1);
        return maxSum(P.length-1,P,dp);
    }
    public static int maxSum(int i,int A[],int[] dp) {
        if(i==0) return A[0];
        if(i==1) return Math.max(A[0],A[1]);
        if(dp[i]!=-1) return dp[i];
        dp[i] = Math.max(A[i]+maxSum(i-2,A,dp),maxSum(i-1,A,dp));
        return dp[i];
    }
}
