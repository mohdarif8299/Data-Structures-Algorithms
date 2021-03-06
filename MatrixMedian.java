public class MatrixMedian {
    public static void main(String[] args) {
        int A[][] = {{5,17,100}};
        System.out.println(solve(A));
    }
    public static int solve(int A[][]) {
        int K = (A.length*A[0].length)/2;
        int low = Integer.MAX_VALUE,high = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++) {
            low = Math.min(low,A[i][0]);
            high = Math.max(high,A[i][A[i].length-1]);
        }
        int median = 0;
        while(low<=high) {
            int mid = (low+high)/2;
            int count = countLess(A,mid);
            int countEqual = (countEqualLess(A,mid)-countLess(A,mid));
            if(count>K) {
                high =mid-1;
            } else {
                if(count+countEqual<=K) {
                low = mid+1;
                }
                else return mid;
            }
        }   
        return median;
    }
    public static int countLess(int A[][],int midElement) {
        int N = A.length;
        int M = A[0].length;
        int low = 1,high =  9;
        int count=0;
            for(int i=0;i<N;i++) {
                int lowRow = 0;
                int highRow = M-1;
                while(lowRow<=highRow) {
                    int rowMid = (lowRow+highRow)/2;
                    if(A[i][rowMid]<midElement) {
                        lowRow = rowMid+1;
                    }
                    else {
                        highRow = rowMid-1;
                    }
                }
                count+=lowRow;
            }
        return count;
    }
    public static int countEqualLess(int A[][],int midElement) {
        int N = A.length;
        int M = A[0].length;
        int low = 1,high =  9;
        int count=0;
            for(int i=0;i<N;i++) {
                int lowRow = 0;
                int highRow = M-1;
                while(lowRow<=highRow) {
                    int rowMid = (lowRow+highRow)/2;
                    if(A[i][rowMid]<=midElement) {
                        lowRow = rowMid+1;
                    }
                    else {
                        highRow = rowMid-1;
                    }
                }
                count+=lowRow;
            }
        return count;
    }
}