import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int A[] = {1, 4, 10, 2, 1, 5 };
        sort(A,0,A.length-1);
        System.out.println(Arrays.toString(A));
    }
    public static void sort(int A[],int low,int high) {
        if(low<high) {
            int pivot = partition(A,low,high);
             sort(A,low,pivot-1);
             sort(A,pivot+1,high);
        }
    }
    public static int partition(int A[],int low,int high) {
        int pivot = A[low];
        int p1=low;
        int p2=high;
        while(p1<p2) {
            while(p1<high)  {
                if(A[p1]>pivot) break;
                p1+=1; 
            }
            while(p2>low) { 
                if(A[p2]<=pivot) break;
                p2-=1; 
            }
            if(p1<=p2) {
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
            }
        }
        A[low]=A[p2];
        A[p2]=pivot;
       return p2;
    }
}