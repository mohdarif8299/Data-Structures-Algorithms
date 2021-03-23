import java.util.*;
public class Queue123 {
    public static void main(String[] args) {
        int A = 2;
        System.out.println(Arrays.toString(solve(A)));
    }
    public static int[] solve(int A) {
        int ANS[] = new int[A];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> ansQueue = new LinkedList<>(); 
        queue.add(1);queue.add(2);queue.add(3);
        int counter = 1;
        int var=queue.poll();
        ansQueue.add(var);
        int mod = A%3;
        for(int i=1;i<A/3;i++) {
            for(int j=1;j<=3;j++) {
               queue.add((var*10)+j);
            }
            var = queue.poll();
            ansQueue.add(var);
        }
        for(int j=1;j<=mod;j++) {
            queue.add((var*10)+j);
         }
        var = queue.poll();
        ansQueue.add(var);
        while(!queue.isEmpty()) ansQueue.add(queue.poll());
        int k=0;
        while(!ansQueue.isEmpty()) {
            ANS[k++] = ansQueue.poll();
        }
        return ANS;
    }
}