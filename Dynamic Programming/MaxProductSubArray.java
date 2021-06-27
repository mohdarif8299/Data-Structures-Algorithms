public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {
        int N = A.length;
        int curr_min=A[0];
        int curr_max = A[0];
        int ans = Math.max(curr_min,curr_max);
        for(int i=1;i<N;i++) {
            int b = A[i]*curr_min;
            int c = A[i]*curr_max;
            curr_min = Math.min(A[i],Math.min(b,c));
            curr_max = Math.max(A[i],Math.max(b,c));
            ans = Math.max(ans,curr_max);
        }
        return ans;
    }
}
