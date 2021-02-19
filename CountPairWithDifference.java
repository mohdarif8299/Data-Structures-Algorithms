import java.util.*;
public class CountPairWithDifference {
    public static void main(String[] args) {
        int A[] = {1,1,1,2,2};
        int B=0;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
       int count=0,p1=0,p2=1;
       Arrays.sort(A);
       while(p2<A.length) {
        if(A[p2]-A[p1]==B) {
                count++;
               p2++;
               p1++;
        }   
           else if(A[p2]-A[p1]>B) {
               p1++;
           }
         
           else p2++;
       }

       return count;
    }
}