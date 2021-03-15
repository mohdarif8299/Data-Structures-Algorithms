import java.util.*;
public class CandiesQueries {
    public static void main(String[] args) {
        int A = 4;
        int B[][] = {{3,4},{2,3}};
        int C[] = {2};
        System.out.println(Arrays.toString(solve(A,B,C)));
    }
    public static int[] solve(int A,int B[][],int C[]) {
        int ARR[] = new int[A];
        int Q[] = new int[C.length];
        for(int i=0;i<B.length;i++) {
            B[i][0] = B[i][0]-1;
            B[i][1] = B[i][1]-1;
        }
        for(int i=0;i<B.length;i++) {
            ARR[B[i][0]]+=1;
            if(B[i][1]+1<ARR.length)
            ARR[B[i][1]+1]-=1;
        }
        for(int i=1;i<ARR.length;i++) {
            ARR[i] = ARR[i-1]+ARR[i]; 
        }
        Arrays.sort(ARR);
        for(int i=0;i<C.length;i++) {
            Q[i] = binarySearch(ARR,C[i]);
        }
        return Q;
    }
    public static int binarySearch(int A[],int X) {
        int low = 0,high = A.length-1;
        int minimumIndex = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A[mid]>=X) {
                minimumIndex = mid;
                high = mid-1;
            }
            //if(A[mid]<X) {
                low= mid+1;
            //}
            //else high = mid-1;
        }
        if(minimumIndex==-1) return 0;
        return A.length-minimumIndex;
    }
}