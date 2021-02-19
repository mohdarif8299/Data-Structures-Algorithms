public class MaximumSubarraySumWithSizeK {
    public static void main(String[] args) {
        int A[] = {3,-1,1,2,5,-3,7};
        int K = 3;
        System.out.println(solve(A,K));
    }
    public static int solve(int A[],int K) {
        int maximum_sum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<K;i++) sum+=A[i];
        int P1=0,P2=K;
        while(P2<A.length) {
            sum-=A[P1];
            P1++;
            sum+=A[P2];
            P2++;
            maximum_sum = Math.max(maximum_sum,sum);
        } 
        return maximum_sum;
    }
}