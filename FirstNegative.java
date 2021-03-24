import java.util.*;
public class FirstNegative {
    public static void main(String[] args) {
        int A[] = {2,-9,6,-7};
        int B = 3;
        System.out.println(Arrays.toString(solve(A,B)));
    }
    public static int[] solve(int A[],int B) {
        int ANS[] = new int[A.length-B+1];
        int K = 0;
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0;i<B;i++) {
            if(A[i]<0) {
                queue.add(i);
            }
        }
        ANS[K++] = A[queue.getFirst()];
        for(int i=B;i<A.length;i++) {
            if(!queue.isEmpty() && queue.getFirst()<(i-B+1)) {
                queue.removeFirst();
            }
            if(A[i]<0) {
                queue.add(i);
            }
        
            if(queue.isEmpty()) ANS[K++] = 0;
            else ANS[K++] = A[queue.getFirst()];
           
        }
        return ANS;
    }
}