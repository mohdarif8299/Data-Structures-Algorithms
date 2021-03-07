import java.util.*;
public class MedianSortedArray {
    public static void main(String[] args) {
        Integer AR[] = {2, 3, 5, 8};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(AR));
        Integer BR[] ={10, 12, 14, 16, 18, 20};
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(BR));
        System.out.println(solve(A,B));
    }
    public static double solve(ArrayList<Integer> A,ArrayList<Integer> B) {
        int K = (A.size()+B.size())/2;
        double median = 0,ans=0;
        median = count(A,B,K);
        ans = count(A,B,K-1);
        if((A.size()+B.size())%2==1) return median;
        return (median+ans)/2;
    }
    public static int count(ArrayList<Integer> A,ArrayList<Integer> B,int K) {
        int low = Math.min(A.get(0),B.get(0));
        int high = Math.max(A.get(A.size()-1),B.get(B.size()-1));
        while(low<=high) {
            int mid = (low+high)/2;
            int count = countLess(A,mid)+countLess(B,mid);
            int countEqual = (countEqualLess(A,mid)-countLess(A,mid))+(countEqualLess(B,mid)-countLess(B,mid));
            if(count>K) {
                high =mid-1;
            } else {
                if(count+countEqual<=K) {
                    low = mid+1;
                }
                else {
                    return mid;
                }
            }
        }  
        return 0;
    }
    public static int countLess(ArrayList<Integer> A,int midElement) {
        int low = 0,high = A.size()-1;
        int elementsCount = 0;
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
    public static int countEqualLess(ArrayList<Integer> A,int midElement) {
        int low = 0,high = A.size()-1;
        int elementsCount = 0;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A.get(mid)<=midElement) {
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