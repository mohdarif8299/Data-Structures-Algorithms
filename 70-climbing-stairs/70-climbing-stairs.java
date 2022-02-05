class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 2;
        return climb(n, dp); 
    }
    public int climb(int n, int dp[]) {
        if(n <= 2) return n;
        if(dp[n] == -1) {
            dp[n] = climb(n-1, dp) + climb(n-2, dp);
        }
        return dp[n];
    }
}