import java.util.*;
public class DequeuMaxMin {
    public static void main(String[] args) {
        int A[]  = {2,5,-1,7,9,-1,-2,6};
        int B = 4;
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B) {
        long maxSum = getMaxSum(A,B);
        long minSum = getMinSum(A,B);
        return (int)((maxSum+minSum+1000000007)%1000000007);
    }
    public static long getMaxSum(int A[],int B){
        Deque<Integer> queue = new LinkedList<>();
        int ARR[] = new int[A.length-B+1];
        long maxSum = 0;
        int k=0;
        for(int i=0;i<B;i++) {
            if(queue.isEmpty()) {
                queue.addLast(i);
            }
            while(!queue.isEmpty() && A[i]>=A[queue.getLast()]) {
                    queue.removeLast();    
            }
            queue.addLast(i);
        }
        maxSum = A[queue.getFirst()];
        for(int i=B;i<A.length;i++) {
            while(!queue.isEmpty() && A[i]>=A[queue.getLast()]) {
                    queue.removeLast();    
            }
            queue.addLast(i);
            
            while(!queue.isEmpty() && queue.getFirst()<(i-B+1))
            queue.removeFirst();
            maxSum += A[queue.getFirst()];
        }
        return maxSum;
    }
    public static long getMinSum(int A[],int B){
        Deque<Integer> queue = new LinkedList<>();
        int ARR[] = new int[A.length-B+1];
        long maxSum = 0;
        int k=0;
        for(int i=0;i<B;i++) {
            if(queue.isEmpty()) {
                queue.addLast(i);
            }
            while(!queue.isEmpty() && A[i]<A[queue.getLast()]) {
                    queue.removeLast();    
            }
            queue.addLast(i);
        }
        maxSum = A[queue.getFirst()];
        for(int i=B;i<A.length;i++) {
            while(!queue.isEmpty() && A[i]<A[queue.getLast()]) {
                    queue.removeLast();    
            }
            queue.addLast(i);
            
            while(!queue.isEmpty() && queue.getFirst()<(i-B+1))
            queue.removeFirst();
            maxSum += A[queue.getFirst()];
        }
        return maxSum;
    }
    
}