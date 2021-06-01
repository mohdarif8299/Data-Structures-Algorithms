public class Solution {
    public int solve(int A, int B, int C) {
        int count=0;
        int low=0,high = Math.min(A,B);
        while(low<=high) {
            int mid = (low+high)/2;
            int A1 = A-mid;
            int B1 = B-mid;
            if(A1+B1+C>=mid && A1>=0 && B1>=0) {
                low = mid+1;
                count = mid;
            } else {
                high = mid-1;
            }
        }
        return count;
    }
}
