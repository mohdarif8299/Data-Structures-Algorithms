public class Solution {
    public int solve(int[] A, int B) {
        Deque<Integer> deq1= new LinkedList<>();
        Deque<Integer> deq2 = new LinkedList<>();
        int check1 = 0;
        int T = B;
        for(int i=0;i<A.length;i++) deq1.add(A[i]);
        while(!deq1.isEmpty()) {
            if(T>=deq1.getFirst()) {
                T = T-deq1.getFirst();
                deq1.removeFirst();
                check1+=1;
            }
            else break;
        }
        T = B;
        int check2 = check1;
        check1=0;
        for(int i=0;i<A.length;i++) deq2.add(A[i]);
        while(!deq2.isEmpty()) {
            if(T>=deq2.getLast()) {
                T-=deq2.getLast();
                deq2.removeLast();
                check1+=1;
            }
            else {
                break;
            }
        }
        return check1>check2?check1:check2;
    }
}
