import java.util.*;
public class ReverseQueue {
    public static void main(String[] args) {
        int A[] = {5, 17, 100, 11};
        int B = 2;
        System.out.println(Arrays.toString(solve(A,B)));
    }
    public static int[] solve(int A[],int B) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<A.length;i++) queue.add(A[i]);
        Queue<Integer> reverseQueue = new LinkedList<>();
       // Queue<Integer> reverseQueue = reverseQueue(new LinkedList<>(queue),new LinkedList<>(),0,B);
        while(count<B) {
            stack.push(queue.poll());
            count++;
        }
        while(!stack.isEmpty()) reverseQueue.add(stack.pop());
        while(!queue.isEmpty()) reverseQueue.add(queue.poll());
        for(int i=0;i<A.length;i++) A[i] = reverseQueue.poll();
        return A;
    }
    // public static Queue<Integer> reverseQueue(Queue<Integer> queue,Queue<Integer> rQueue,int i,int B) {
    //     if(i==B) {
    //         return rQueue;
    //     }
    //     int temp = queue.poll();
    //     reverseQueue(queue,rQueue,i+1,B);
    //      rQueue.add(temp);
    //     //return rQueue;
    // }
}