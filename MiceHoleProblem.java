public class Solution {
    public int mice(int[] A, int[] B) {
        long maxTime=Integer.MIN_VALUE;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++) {
            maxTime =Math.max(maxTime,Math.abs(A[i]-B[i]));
        }
        return (int)(maxTime%1000000007);
    }
}
