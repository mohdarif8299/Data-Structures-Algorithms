public class MaxChunks2 {
    public static void main(String[] args) {
        int A[] = {2,0,1,2};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        int ans=0;
        int L[] = new int[A.length];
        int R[] = new int[A.length];
        L[0] = A[0];
        for(int i=1;i<L.length;i++) L[i] = Math.max(L[i-1],A[i]);
        R[R.length-1] = A[A.length-1];
        for(int i=R.length-2;i>=0;i--) R[i] = Math.min(R[i+1],A[i]);
        for(int i=0;i<L.length-1;i++) {
            if(L[i]<=R[i+1]) ans++;
        }
        return ans+1;
    }
}