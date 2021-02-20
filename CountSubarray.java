import java.util.*;
public class CountSubarray {
    public static void main(String[] args) {
        int A[] = {2,1,2};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        int L=0,R=0;
        while(R<A.length) {
         
            if(map.containsKey(A[R])) {
                L++;
                count+=(R-L+1);
            }
            else {
                map.put(A[R],1);
                count+=(R-L+1);
            }
            R++;
        }
        return count;
    }
}