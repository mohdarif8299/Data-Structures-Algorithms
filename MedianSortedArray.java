import java.util.*;
public class MedianSortedArray {
    public static void main(String[] args) {
        Integer AR[] = {1,4,5 };
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(AR));
        Integer BR[] ={2,3};
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(BR));
        System.out.println(solve(A,B));
    }
    public static double solve(ArrayList<Integer> A,ArrayList<Integer> B) {
        int low = Math.min(A.get(0),B.get(0));
        int high = Math.max(A.get(A.size()-1),B.get(B.size()-1));
        double median = 0;
        while(low<=high) {
            int mid = (low+high)/2;
            int X = (A.size()+B.size())/2;
            long count = count(A,mid);
            count+=count(B,mid);
            if(count==X) {
                median = mid;
                low = mid+1;
            }
            else if(count<X) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return median;
    }
    public static long count(ArrayList<Integer> A,int midElement) {
        int low = 0,high = A.size()-1;
        long elementsCount = 0;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A.get(mid)<midElement) {
                elementsCount = mid+1;
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return elementsCount;
    }
}