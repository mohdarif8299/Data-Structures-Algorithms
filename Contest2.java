import java.util.*;
public class Contest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int A[] = new int[K];
            for(int i=0;i<K;i++) {
                A[i] = sc.nextInt();
            }
            for(int i=0;i<N;i++) {
                int score=0;
                String S = sc.next();
                for(int j=0;j<K;j++) {
                    score+= Integer.parseInt(S[i].charAt(j)+"")*A[j];
                }
                System.out.println(score);
            }
        }
    }
}