import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumberRange {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            int A[] = seive();
            //System.out.println(Arrays.toString(A));
            int MAX = 0,MIN=0;
            for(int i=L;i<=R;i++) {
                if(A[i]==0) {
                    MIN = i;
                    break;
                }
            }
            for(int i=R;i>=L;i--) {
                if(A[i]==0) {
                    MAX = i;
                    break;
                }
            }
            if(MAX==0 && MIN ==0) {
                System.out.println(-1);
            }
            else if(MIN==0 || MAX ==0) {
                System.out.println(0);
            }
            else {
                System.out.println(MAX-MIN);
            }
        }
    }
    public static int[] seive() {
        int N = 1000001;
        int prime[] = new int[N+1];
        prime[0] = 1;
        prime[1] = 1;
        for(int i=2;i*i<=N;i++) {
             for(int j=i*i;j<=N;j+=i) {
                 if(prime[j]==0) {
                     prime[j] = 1;
                 }
             }
        }
        
        return prime;
    }
}