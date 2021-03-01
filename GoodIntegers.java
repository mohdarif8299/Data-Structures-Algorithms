public class GoodIntegers {
    public static void main(String[] args) {
        int A = 30;
        int B = 25;
        System.out.println(solve(A,B));
    }
    public static int solve(int A,int B) {
        long low = B ,high = A;
        if(B>A) return 0;
        while(low<=high) {
            long mid = (low+high)/2;
            long SUM = sumDigits(mid);
            if(SUM>=B && SUM<=A) {
                high = mid-1;
                
            }
            else low = mid+1; 
        }
        return (int)(A-high);
    }
    public static long sumDigits(long N) {
        long X = 0;
        long M = N;
        while(N>0) {
            X+= N%10;
            N/=10;
        }
        return M-X;
    }
}