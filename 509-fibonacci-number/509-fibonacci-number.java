class Solution {
    public int fib(int n) {
        if(n < 2) return n;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 1;
        return fib(n, dp);
    }
    public int fib(int n , int dp[]) {
        if(n <= 2) return dp[n];
        if(dp[n] == -1) {
            dp[n] = fib(n-1, dp) + fib(n-2, dp);
        }
        return dp[n];
    }
}