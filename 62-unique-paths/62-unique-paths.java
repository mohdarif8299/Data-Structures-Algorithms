class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        for(int temp[]: dp) 
            Arrays.fill(temp, -1);
        
        return uniqueWays(m-1, n-1, dp);
    }
    public int uniqueWays(int i, int j, int dp[][]) {
        
        if( i==0 || j ==0 ) return 1;
        
        
        if(dp[i][j] == -1) {
            dp[i][j] = uniqueWays(i-1, j, dp) + uniqueWays(i, j-1, dp);
        }
        
        return dp[i][j];
        
    }
}