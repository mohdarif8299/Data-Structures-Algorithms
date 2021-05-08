public class Solution {
    public int nchoc(int A, int[] B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        long totalChocolate=0;
        for(int i=0;i<B.length;i++) {
            maxHeap.add(B[i]);
        }
        for(int i=0;i<A;i++) {
            int x=maxHeap.poll();
            totalChocolate+=x;
            maxHeap.add(x/2);
        }
        return (int)(totalChocolate%1000000007);
    }
}
