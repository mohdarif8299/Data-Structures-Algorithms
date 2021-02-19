public class AbsoluteDifference {
    public static void main(String[] args) {
       int A[] = {1, 4, 5, 8, 10};
       int B[] = { 6, 9, 15 };
       int C[] = {2, 3, 6, 6};
       System.out.println(solve(A,B,C)); 
    }
    public static int solve(int A[],int B[],int C[]) {
        int ans = Integer.MAX_VALUE;
        int P1=0,P2=0,P3=0;
        while(P1<A.length && P2<B.length && P3<C.length) {
            int minimum = MinimumPointer(A[P1],B[P2],C[P3]);
            int maximum = MaximumPointer(A[P1],B[P2],C[P3]);
            ans = Math.min(ans,Math.abs(maximum-minimum));
            if(A[P1]<B[P2] && A[P1]<C[P3])P1++;
            else if(B[P2]<C[P3]) P2++;
            else P3++;
        }
        return ans;
    }
    public static int MinimumPointer(int A,int B,int C) {
        return A<B&&A<C?A:B<C?B:C;
    }
    public static int MaximumPointer(int A,int B,int C) {
        return A>B&&A>C?A:B>C?B:C;
    }
}