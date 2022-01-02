class Solution {
    public int climbStairs(int n) {
     int dp[] = new int[n+1];
     Arrays.fill(dp, -1);
     if(n < 2) return 1;
     dp[1] = 1;
     dp[2] = 2;
        return stairsCount(dp, n);
    }
    public static int stairsCount(int dp[], int n) {
        if(n == 1) return dp[1];
        if(n == 2) return dp[2];
        if(dp[n]!=-1) return dp[n];
        else {
            dp[n] = stairsCount(dp, n - 1) + stairsCount(dp, n - 2);
        }
        return dp[n];
    }
}