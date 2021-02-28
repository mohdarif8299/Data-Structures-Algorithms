public class AthMagicalNumber {
    public static void main(String[] args) {
        int A = 807414236;
        int B = 3788;
        int C = 38141;
        System.out.println(solve(A,B,C));
    }
    public static int solve(int A,int B,int C) {
        long lcm = (1L*B*C)/gcd(B,C);
        long ANS = 0;
        long low = 1,high = 1L*A*Math.max(B,C);
        while(low<=high) {
            long mid = (low+high)/2;
            if(numberCount(mid,B,C,lcm)>=A) {
                ANS = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return (int)(ANS%1000000007);
    }
    public static long numberCount(long num,int B,int C,long lcm) {
       return num/B+num/C-num/lcm;
    }
    public static int gcd(int A,int B) {
        if(A==0) return B;
        return gcd(B%A,A);
    }
}