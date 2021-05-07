public class Solution {
    public int solve(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(A[0]);
        double median = (double)A[0];
        // left->right
        for(int i=1;i<A.length;i++) {
              //System.out.println(median+" "+(double)A[i]);
            if((double)A[i]==median) return 1;
            if(A[i]>maxHeap.peek()) {
                minHeap.add(A[i]);
            } else {
                maxHeap.add(A[i]);
            }
            if(maxHeap.size()!=0 && maxHeap.size()==minHeap.size()) {
                median = (double)(maxHeap.peek()+minHeap.peek())/2;
            } else if(maxHeap.size()-minHeap.size()==1) {
                 median =(double) maxHeap.peek();
            } else if(maxHeap.size()-minHeap.size()>1){
                minHeap.add(maxHeap.poll());
                median = (double)(maxHeap.peek()+minHeap.peek())/2;
            } else if(minHeap.size()-maxHeap.size()==1) {
                median =(double) minHeap.peek();
            } else if(minHeap.size()-maxHeap.size()>1) {
                maxHeap.add(minHeap.poll());
                median = (double)(maxHeap.peek()+minHeap.peek())/2;
            }
        }
        median = (double)A[A.length-1];
        minHeap.clear();
        maxHeap.clear();
        maxHeap.add(A[A.length-1]);
        // right->left
        for(int i=A.length-2;i>=0;i--) {
            //System.out.println(median);
            if((double)A[i]==median) return 1;
            if(A[i]>maxHeap.peek()) {
                minHeap.add(A[i]);
            } else {
                maxHeap.add(A[i]);
            }
            if(maxHeap.size()!=0 && maxHeap.size()==minHeap.size()) {
                median = (double)(maxHeap.peek()+minHeap.peek())/2;
            } else if(maxHeap.size()-minHeap.size()==1) {
                 median =(double) maxHeap.peek();
            } else if(maxHeap.size()-minHeap.size()>1){
                minHeap.add(maxHeap.poll());
                median = (double)(maxHeap.peek()+minHeap.peek())/2;
            } else if(minHeap.size()-maxHeap.size()==1) {
                median =(double) minHeap.peek();
            } else if(minHeap.size()-maxHeap.size()>1) {
                maxHeap.add(minHeap.poll());
                median =(double) (maxHeap.peek()+minHeap.peek())/2;
            }
        }
        return 0;
    }
}
