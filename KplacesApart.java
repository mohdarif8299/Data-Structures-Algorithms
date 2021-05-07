public class Solution {
    public int[] solve(int[] A, int B) {
        if(B==0) return A;
        int ans[] = new int[A.length];
        int k=0;
        PriorityQueue<Integer> minHeap= new PriorityQueue<>(B+1);
        for(int i=0;i<A.length;i++) {
            if(minHeap.size()<=B) {
                minHeap.add(A[i]);
            }
            else {
                ans[k++] = minHeap.poll();
                minHeap.add(A[i]);
            }
        }
        while(minHeap.size()!=0) ans[k++] = minHeap.poll();
        return ans;
    }
}
