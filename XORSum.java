import java.util.*;
public class XORSum {
    public static void main(String[] args) {
        int A[] = {3, 6, 8, 10, 15, 50};
        int B = 5;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        int count=0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<A.length;i++) {
            int X = B^A[i];
            if(set.contains(X)) {
                count++;
            }
            else set.add(A[i]);
        }
        return count;
    }
}