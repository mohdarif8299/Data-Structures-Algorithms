public class PairCount {
    public static void main(String[] args) {
        int A[] = {2,7,9,12,13};
        int B[] = {1,5,6,8};
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B[]) {
        int ans=0;
        int p1=0,p2=0;
        while(p1<A.length && p2<B.length) {
            if(A[p1]>B[p2]) {
                ans+=((A.length-p1));
                p2++;
            }
            else p1++;
        }
        return ans;
    }
}