public class MaximumNumber {
    public static void main(String[] args) {
        int A[] = {1,2,3,4,5};
        int S=14;
        solve(A,S);
    }
    public static void solve(int A[],int S) {
        long prefix[] = new long[A.length+1];
        for(int i=0;i<A.length;i++) prefix[i+1] = A[i]+prefix[i];
        System.out.println(binarySearch(prefix,A.length,S));
    }
    public static int binarySearch(long A[],int n,int S) {
        int ans=0;
        int low=1,high=n;
        while(low<=high) {
            int mid = (low+high)/2;
            int i;
            for(i=mid;i<=n;i++) {
                if(A[i]-A[i-mid]>S) break;
            }
            if(i==n+1) {
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
}