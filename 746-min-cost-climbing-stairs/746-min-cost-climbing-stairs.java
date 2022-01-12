class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(min(0, cost, dp), min(1, cost, dp));
    }
    public static int min(int n, int cost[], int dp[]) {
        if(n >= cost.length) return 0;
        if (dp[n] == -1) {
            dp[n] =  cost[n] + Math.min(min(n+1, cost, dp), min(n+2, cost, dp));
        }
        return dp[n];
    }
}