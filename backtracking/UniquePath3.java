public class Solution {
    public int solve(int[][] A) {
        int countZeroes =0;
        int start = 0,end=0;
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[0].length;j++) {
                if(A[i][j]==1) {
                    start=i;
                    end = j;
                } else if(A[i][j]==0) {
                    countZeroes++;
                }
            }
        }
        return count(start,end,A.length,A[0].length,A,countZeroes,0);
    }
    public static int count(int i,int j,int R,int C,int A[][],int zero,int count) {
        
        if( i>=R || i<0 || j>=C || j<0 || A[i][j]==-1) return 0;
        if(A[i][j]==2) { 
            if(zero==0) return 1;
          return 0; 
        }
        if(A[i][j]==0) zero--;
        A[i][j]=-1;
        int x = count(i-1,j,R,C,A,zero,count);
        int y = count(i+1,j,R,C,A,zero,count);
        int z = count(i,j-1,R,C,A,zero,count);
        int p = count(i,j+1,R,C,A,zero,count);
         A[i][j]=0;
         return x+y+z+p;
    }
}
