public class Solution {
    public int[] solve(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);
        int ans[] = new int[A.length];
        int product=1;
        for(int i=0;i<A.length;i++) {
            if(minHeap.size()<3) {
                minHeap.add(A[i]);
                product*=A[i];
            }
            else {
                if(A[i]>minHeap.peek()) {
                    int x = minHeap.poll();
                    product/=x;
                    minHeap.add(A[i]);
                    product*=A[i];
                }
            }
            if(minHeap.size()==3) {
                ans[i] = product;
            }
            else {
                ans[i]=-1;
            }
        }
        return ans;
    }
}
