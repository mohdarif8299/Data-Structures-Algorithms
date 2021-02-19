import java.util.*;
public class SubarrayWithSum {
    public static void main(String[] args) {
        int A[] = {1,10 };
        int K =10 ;
        System.out.println(Arrays.toString(solve(A,K)));
    }
    public static int[] solve(int A[],int K) {
        int P1=0,P2=1;
        int sum = A[P1];
        while(P2<A.length) {
            while(sum<K && P2<A.length) {
                sum+=A[P2];
                P2++;
            }
            while(sum>K && P1<A.length) {
                sum-=A[P1];
                P1++;
            }
            if(sum==K){
                int ARR[] = new int[P2-P1];
                for(int i=0;i<ARR.length;i++) ARR[i]= A[i+P1];
                return ARR;
            }
        }
        return new int[]{-1};
    }
}