public class Solution {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<A.length;i++) {
            minHeap.add(A[i]);
        }
        int sum=0;
        for(int i=0;i<B;i++) {
            int element = minHeap.poll();
            minHeap.add(-element);
        }
        while(!minHeap.isEmpty()){
            sum+=minHeap.poll();
        }
        return sum;
    }
}
