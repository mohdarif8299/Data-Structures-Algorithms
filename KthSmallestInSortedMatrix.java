public class Solution {
    public int solve(int[][] A, int B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[i].length;j++) {
                if(maxHeap.size()<B)
                   maxHeap.add(A[i][j]); 
                else { 
                   if(A[i][j]<maxHeap.peek()) {
                       maxHeap.poll();
                       maxHeap.add(A[i][j]);
                   } 
                }
            }
        }
        return maxHeap.poll();
    }
}
