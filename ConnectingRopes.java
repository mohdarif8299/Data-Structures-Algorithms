public class Solution {
    public int solve(int[] A) {
        int minimumCost=0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0;i<A.length;i++) {
           minHeap.add(A[i]); 
        }
        while(minHeap.size()!=1) {
            int min = minHeap.poll();
            int min2 = minHeap.poll();
            minimumCost+=min+min2;
            minHeap.add(min+min2);
        }
        return minimumCost;
    }
}
