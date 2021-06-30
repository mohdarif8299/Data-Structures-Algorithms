public class Solution {
    public int solve(int[] A, int[] B, int C) {
        int dp[][] = new int[A.length+1][C+1];
        for(int p[]:dp) Arrays.fill(p,-1);
        return knapsack(0,A,B,C,dp);
    }
    public static int knapsack(int i,int[] A,int B[],int C,int dp[][]) {
        if(i==A.length) return 0;
        if(C==0) return 0;
        if(dp[i][C]!=-1) return dp[i][C];
        int x=0,y=0;
        if(C-B[i]>=0) {
            x = Math.max(knapsack(i+1,A,B,C-B[i],dp)+A[i],knapsack(i+1,A,B,C,dp));
        } else {
            y = knapsack(i+1,A,B,C,dp);
        }
        dp[i][C] = Math.max(x,y);
        return dp[i][C];
    }
}
