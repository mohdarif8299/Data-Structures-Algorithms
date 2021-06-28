public class Solution {
    public int numDistinct(String A, String B) {
     int dp[][] = new int[A.length()][B.length()];
     for(int[] a:dp) Arrays.fill(a,-1);
     return subsequences(0,0,A,B,dp);
    }
     public static int subsequences(int i,int j,String A,String B,int dp[][]) {
        
        if(j==B.length()) return 1;
        if(i==A.length()) return 0;
        
        
        int totalSum=0;
        // If Found Both Equal
        if(dp[i][j]!=-1) return dp[i][j];
        if(A.charAt(i)==B.charAt(j)) 
           dp[i][j]=  subsequences(i+1,j+1,A,B,dp) + subsequences(i+1,j,A,B,dp);
        else {
           dp[i][j] = subsequences(i+1,j,A,B,dp);
        }
        return dp[i][j];
    }
}
