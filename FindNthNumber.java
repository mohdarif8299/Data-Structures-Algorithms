public class FindNthNumber {
    public static void main(String[] args) {
        int A = 2;
        int B = 4;
        int C = 2;
        int D = 5;
        System.out.println(solve(A,B,C,D));
    }
    public static int solve(int A,int B,int C,int D) {
        long low = 1,high = Integer.MAX_VALUE;
        while(low<high) {
            long mid = (low+high)/2;
            if(totalNumber(A,B,C,mid)<D) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return (int)low;
    }
    public static long gcd(long A,long B) {
        if(A==0) return B;
        return gcd(B%A,A);
    }
    public static long lcm(long A,long B) {
        return ((A*B)/gcd(A,B));
    }
    public static long totalNumber(long A,long B,long C,long mid) {
        return (mid/A+mid/B+mid/C)-mid/lcm(A,B)-mid/lcm(B,C)-mid/lcm(A,C)+mid/lcm(A,lcm(B,C));
    }
}