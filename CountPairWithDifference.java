import java.util.*;
public class CountPairWithDifference {
    public static void main(String[] args) {
        int A[] = {1,1};
        int B=0;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
       int count=0,P1=0,P2=1;
       Arrays.sort(A);
       System.out.println(Arrays.toString(A));
       while(P2<A.length) {
        while(P1<P2-1 && A[P1]==A[P1+1]) {
            P1++;
        }
        while(P2<A.length-1 && A[P2]==A[P2+1]) {
            P2++;
        }
        System.out.println(P1+"   "+P2);
         if(A[P2]-A[P1]==B && P1!=P2) {
               count++;
               P2++;
               P1++;
        }   
        else if(A[P2]-A[P1]>B)   P1++;
         else P2++;
       }

       return count;
    }
}