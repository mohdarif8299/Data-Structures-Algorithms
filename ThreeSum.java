import java.util.*;
public class ThreeSum {
    public static void main(String[] args) {
        int A[] = { 2, 1, -9, -7, -8, 2, -8, 2, 3, -8};
      //  int A[] = {10, -6, 3, 4, -8, -5};
        int B = -1;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        int sum=0;
        ArrayList<Integer> Al = new ArrayList<>();
        Arrays.sort(A);
        for(int i=0;i<A.length-2;i++) {
            int j = i+1;
            int k = A.length-1;
            while(j<k) {
                 sum = A[i]+A[j]+A[k];
                if(sum==B) {
                    return sum; 
                }
                else if(sum<B) {
                    j++;
                }
                else  {
                    k--;
                }
            }
            if((B<0 && sum<0) || (B>0 && sum>0))
            Al.add(sum);
        }
        System.out.println(Al);
        int low = 0,high = Al.size()-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(Al.get(mid)<B) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
       // if(B<0)
        return Al.get(high);
        // return Al.get(high+1);
    }
}