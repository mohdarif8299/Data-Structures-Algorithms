public class SearchInRotatedArray {
    public static void main(String[] args) {
        int A[] = {0,1,2,3,4,5};
        int target = 0;
        System.out.println(solve(A,target));
    }
    public static int solve(int A[],int target) {
       int K = getRotatedFactor(A);
       int low = 0,high = K-1;
       while(low<=high) {
           int mid = (low+high)/2;
           if(A[mid]==target) return mid;
           else if(A[mid]<target) low = mid+1;
           else high = mid-1;
       }
       low = K;
       high = A.length-1;
       while(low<=high) {
        int mid = (low+high)/2;
        if(A[mid]==target) return mid;
        else if(A[mid]<target) low = mid+1;
        else high = mid-1;
      }
      return -1;
    }
    public static int getRotatedFactor(int A[]) {
        int N = A.length;
        int low = 0,high = N-1;
        int rotatedFactor=0;
        while(low<=high) {
            int mid = (low+high)/2;
            if(A[0]<=A[mid]) {
                low =  mid+1;
            }
            else {
                rotatedFactor = mid;
                high = mid-1;
            }
        }
        return rotatedFactor;
    }
}