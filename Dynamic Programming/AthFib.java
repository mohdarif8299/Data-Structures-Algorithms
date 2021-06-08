import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int dp[] = new int[A+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1] = 1;
        System.out.println(fib(A,dp));
        
    }
    public static int fib(int n,int dp[]) {
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        dp[n] = fib(n-1,dp)+fib(n-2,dp);
        return dp[n];
    }
}
