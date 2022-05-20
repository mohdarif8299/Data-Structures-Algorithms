class Solution {
    public int uniquePathsWithObstacles(int[][] A) {
        int dp[][] = new int[A.length][A[0].length];
        int start = 0,end=0;
        for(int d[]: dp) 
            Arrays.fill(d, -1);
        return count(start,end,A.length,A[0].length,A, dp);
    }
    public static int count(int i,int j,int R,int C,int A[][], int dp[][]) {
        
        if(i>=R || j>=C || A[i][j]==1) return 0;
        if(i==R-1 && j==C-1) {
            return 1; 
        }
        if(dp[i][j] != -1) return dp[i][j]; 
        A[i][j]=1;
        dp[i][j] = count(i,j+1,R,C,A,dp) + count(i+1,j,R,C,A,dp);
        A[i][j]=0;
        return dp[i][j];
    }
    
}