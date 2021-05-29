class Solution {
    public int countNegatives(int[][] A) {
        int count=0;
        int index = A[0].length-1;
        for(int i=0;i<A.length;i++) {
            for(int j=index;j>=0;j--) {
                index=j;
                if(A[i][j]<0) {
                    count+=(A.length-i);
                    if(index==0) return count;
                }
                else break;
            }
             
        }
        return count;
    }
}
