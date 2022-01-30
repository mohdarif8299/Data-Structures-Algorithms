class Solution {
    public int tribonacci(int n) {
        if( n == 0) return 0;
        if(n <=2) return 1;
        int dp[] = new int[n+1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        dp[2] = 1;
        return tri(n, dp);
    }
    public int tri(int n, int dp[]) {
        if( n <= 2) return dp[n];
        if(dp[n] == 0) {
            dp[n] = tri(n-1, dp) + tri(n-2, dp) + tri(n-3, dp);
        }
        return dp[n];
    }
}