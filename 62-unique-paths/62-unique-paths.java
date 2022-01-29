class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int arr[]: dp) {
            Arrays.fill(arr, -1);
        }
        return countWays(m-1, n-1, dp);
        
    }
    public int countWays(int i, int j, int dp[][]) {
        if( i == 0 || j == 0) return 1;
        if(dp[i][j]==-1) {
            dp[i][j] = countWays(i-1, j, dp) + countWays(i, j-1, dp);
        }
        return dp[i][j];
    }
}