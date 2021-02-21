import java.util.*;
public class PairWithSumII {
    public static void main(String[] args) {
        int A[] = { 1, 1,1};
        int B=2;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        int count=0;
        int i=0,j=A.length-1;
        while(i<j) {
            if(A[i]+A[j]==B) {
               if(A[i]==A[j]) {
                   int x = j-i+1;
                   count+=(x*(x-1)/2);
                   break;
               }
               else {
                   int a=1,b=1;
                   while(i<j && A[i]==A[i+1]) {
                    i++;   
                    a++;
                   }
                   while(j>i && A[j]==A[j-1]) {
                    j--;
                    b++;
                }
                count+=a*b;
               }

            }  
            if(A[i]+A[j]>B) j--;
            else i++;
            
        }
        return count;
    }
}