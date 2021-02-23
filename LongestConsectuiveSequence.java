import java.util.*;
public class LongestConsectuiveSequence {
    public static void main(String[] args) {
        int A[] = {2,6,4,7,9};
        System.out.println(solve(A));
    }
    public static int solve(int A[]) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<A.length;i++) set.add(A[i]);
        int max = Integer.MIN_VALUE,count=1;
        for(int i=0;i<A.length;i++) {
            if(!set.contains(A[i]-1)) {
                int X = A[i];
                while(set.contains(X+1)) {
                  count+=1;
                  X+=1;
                 
                }
             }
            max = Math.max(max,count);
            count=1;
        }
        return max;
    }
}