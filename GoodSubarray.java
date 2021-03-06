import java.util.*;
public class GoodSubarray {
    public static void main(String[] args) {
        int A[] = {1,2,3,4,5};
        int B =10;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        int Prefix[] = new int[A.length+1];
        long count=0,oddCount=0;
        for(int i=1;i<Prefix.length;i++) {
            Prefix[i] = Prefix[i-1]+A[i-1];
        }
        for(int i=0;i<A.length;i++) {
            int j = binarySearch(Prefix,i,B);
            if(j==-1) continue;
            count+=(j-i)/2;
        }
        for(int i=0;i<A.length;i++) {
            int j =oddSubarray(Prefix,i,B);
            if(j==-1) continue;
            int Y = ((A.length-i+1)/2)-((j-i)/2);
            oddCount+=Y;
        }
        return (int)(oddCount+count>100000000?100000000:oddCount+count);
    }
    public static int binarySearch(int A[],int i,int B) {
        int low = i,high =A.length-1;
        int j=-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A[mid]-A[i]<B) {
                j = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return j;
    }
    public static int oddSubarray(int A[],int i,int B) {
        int low = i,high =A.length-1;
        int j=-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A[mid]-A[i]>B) {
                j = mid;
                high = mid-1;
            }
            else low = mid+1; 
        }
        return j;
    }
}