import java.util.*;
public class SortByColor {
    public static void main(String[] args) {
        int A[] = {2,1,0,1,0,2};
        int ARR[] = solve(A);
        System.out.println(Arrays.toString(ARR));
    }
    public static int[] solve(int A[]) {
        int P1=0,P2=A.length-1;
        int P=0;
        while(P<=P2) {
            if(A[P]==0) {
                int temp = A[P];
                A[P] = A[P1];
                A[P1] = temp;
                P++;
                P1++;
            }
            else if(A[P]==1) P++;
            else {
                int temp = A[P];
                A[P] = A[P2];
                A[P2] = temp;
                P2--;
            }
       }
        return A;
    }
}