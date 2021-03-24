import java.util.*;
public class DequeMax {
    public static void main(String[] args) {
        int A[]  = {718, 622, 531, 279, 442, 893, 282, 875, 252, 70, 402, 663, 22, 69, 611, 412, 302, 840, 589, 668, 346, 983, 227, 23, 703, 818, 100, 943, 728, 305, 72, 772, 35, 721, 550, 12, 405, 454, 902, 978, 579};
        int B = 9;
        System.out.println(Arrays.toString(solve(A,B)));
    }
    public static int[] solve(int A[],int B) {
        Deque<Integer> queue = new LinkedList<>();
        int ARR[] = new int[A.length-B+1];
        long maxSum = 0,minSum=0;
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
        ARR[k++] = A[queue.getFirst()];
        for(int i=B;i<A.length;i++) {
            while(!queue.isEmpty() && A[i]>=A[queue.getLast()]) {
                    queue.removeLast();    
            }
            queue.addLast(i);
            
            while(!queue.isEmpty() && queue.getFirst()<(i-B+1))
            queue.removeFirst();
            ARR[k++] = A[queue.getFirst()];
        }
        return ARR;
    }
}