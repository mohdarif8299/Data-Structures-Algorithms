public class MissingPositiveNumber {
    public static void main(String[] args) {
        int A[] = {1,2,3,4,5,7,9,11};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        int ans=1;
        if(A[0]!=1) return ans;
        int low = 0,high = A.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A[mid]-1==mid) {
                ans = mid+1;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return ans+1;
    }
}