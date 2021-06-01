public class Solution {
    public int solve(int[] A, int[] B) {
        int total = 0;
        Arrays.sort(B);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<A.length;i++) maxHeap.add(A[i]);
        for(int i=B.length-1;i>=0;i--) {
            if(!maxHeap.isEmpty() && B[i]<=maxHeap.peek()) {
                total+=B[i];
                maxHeap.poll();
            }
        }
        return total;
    }
}
