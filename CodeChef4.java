import java.util.*;
public class CodeChef4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int N = sc.nextInt();
            int A[] = new int[N];
            for(int i=0;i<N;i++) A[i] = sc.nextInt();
            System.out.println(solve(A));
        }
    }
    public static String solve(int A[]) {
        Arrays.sort(A);
        long sum=0;
        for(int i=0;i<A.length;i++) {
            if(A[i]>i+1) {
                return "Second";
            }
            sum+=((i+1)-A[i]);
        }
        if(sum%2==1)  return "First";
        return "Second";
    }
}