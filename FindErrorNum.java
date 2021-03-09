import java.util.*;
public class FindErrorNum {
    public static void main(String[] args) {
        int A[] = {2,2};
        System.out.println(Arrays.toString(solve(A)));
    }
    public static int[] solve(int A[]) {
        int AR[] = new int[10001];
        int duplicate=-1,missing=-1;
        for(int i=0;i<A.length;i++) {
            AR[A[i]]++;
        }
        for(int i=1;i<AR.length;i++) {
            if(AR[i]>1) {
                duplicate = i;
            }
        }
        for(int i=1;i<AR.length;i++) {
            if(AR[i]==0) {
                missing = i;
                break;
            }
        }
        return new int[]{duplicate,missing};
    }
}