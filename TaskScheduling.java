import java.util.*;
public class TaskScheduling  {
    public static void main(String[] args) {
        int A[] = {2,3,1,5,4};
        int B[] = {4,1,5,3,2};
        System.out.println(solve(A,B));
    }
    public static int solve(int A[],int B[]) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();
        for(int i=0;i<A.length;i++) queue.add(A[i]);
        for(int i=0;i<B.length;i++) {
             while(!queue.isEmpty() && B[i]!=queue.peek()) {
                 tempQueue.add(queue.poll());
                 count+=1;
             }
             queue.poll();
             while(!tempQueue.isEmpty()) queue.add(tempQueue.poll());
             count+=1;
        }
        return count;
    }
}