public class Solution {
    public int[] solve(int[] A, int[] B) {
      int ANS[] = new int[B.length];


        // compute presum
        for(int i=1;i<A.length;i++) {
            A[i] = A[i-1]+A[i];
        }

        // implement Binary Search for Upper Bound
        for(int i=0;i<B.length;i++) {
           ANS[i] = binarySearch(A,B[i]);
        }
        return ANS;
    }

    public static int binarySearch(int A[],int n) {
        int start = 0;
        int end = A.length-1;
        if(A[end]<n) return end+1;
        if(A[start]>n) return 0;
        while(start<end) {
            int mid = (start+end)/2;
            if(A[mid]<=n) start= mid+1;
            else  {
               end =mid;
            }
        }
        return A[start] > n ? start : -1;
    }
}
