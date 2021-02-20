import java.util.*;
public class IntersectionArray {
    public static void main(String[] args) {
        int A[] = {1,2,3,3,4,5,6};
        int B[] = {3,5};
        System.out.println(solve(A,B));
    }
    public static ArrayList<Integer> solve(int A[],int B[]) {
        ArrayList<Integer> ANS = new ArrayList<>();
        int P1=0,P2=0,K=0;
        while(P1<A.length && P2<B.length) {
            if(A[P1]==B[P2]) {
                ANS.add(A[P1]);
                P1++;P2++;
            }
            else if(A[P1]<B[P2]) P1++;
            else P2++;
        }
        return ANS;
    }
}