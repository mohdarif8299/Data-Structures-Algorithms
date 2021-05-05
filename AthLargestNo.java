public class Solution {
    public int[] solve(int A, int[] B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int ans[] = new int[B.length];
        for(int i=0;i<B.length;i++) {
            if(minHeap.size()<A) { 
                minHeap.add(B[i]);
            }
            else {
                if(B[i]>minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(B[i]);
                }
            }
            if(minHeap.size()>=A) ans[i] = minHeap.peek();
            else ans[i] = -1;
        }
        return ans;
    }
}
