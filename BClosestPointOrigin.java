public class Solution {
  
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(B,Collections.reverseOrder());
        for(int i=0;i<A.size();i++) {
            int p1 = A.get(i).get(0) *A.get(i).get(0); 
            int p2 = A.get(i).get(1) *A.get(i).get(1); 
            heap.add(p1+p2);
            if(heap.size()>B) heap.poll();
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int maxPoint = heap.peek();
        for(int i=0;i<A.size();i++) {
            int point = A.get(i).get(0)*A.get(i).get(0)+A.get(i).get(1)*A.get(i).get(1);
            if(point<=maxPoint)
            ans.add(A.get(i));
        }
        return ans;
    }
}
