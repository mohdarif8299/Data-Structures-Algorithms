public class Solution {
    public String solve(int[] A) {
        int min = Integer.MIN_VALUE,max = Integer.MAX_VALUE;
        int node_val = A[0];
        for(int i=1;i<A.length;i++) {
            if(A[i]>node_val) min = node_val;
            else max = node_val;
            if(A[i]<min || A[i]>max) return "NO";
            node_val = A[i];
        }
        return "YES";
    }
}
