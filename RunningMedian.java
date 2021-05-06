public class Solution {
    public int[] solve(int[] A) {
        int ans[] = new int[A.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(A[0]);
        ans[0] = A[0];
        for(int i=1;i<A.length;i++) {
           if(A[i]>maxHeap.peek()) {
               minHeap.add(A[i]);
           } else {
               maxHeap.add(A[i]);
           }
           if(maxHeap.size()==minHeap.size()) {
               ans[i] = maxHeap.peek();
           } else if(minHeap.size()-maxHeap.size()==1) {
               ans[i] = minHeap.peek();
           }  else if(minHeap.size()-maxHeap.size()>1) {
                   maxHeap.add(minHeap.poll());
                  ans[i] = maxHeap.peek();
           } else if(maxHeap.size()-minHeap.size()==1) {
               ans[i] = maxHeap.peek();
           }  else if(maxHeap.size()-minHeap.size()>1) {
                   minHeap.add(maxHeap.poll());
                  ans[i] = maxHeap.peek();
           }  
        }
        return ans;
    }
}
