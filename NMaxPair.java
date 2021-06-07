public class Solution {
    public static class Pair {
        int i;
        int j;
        int sum;
        Pair(int i,int j,int sum) {
            this.i=i;
            this.j = j;
            this.sum=sum;
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A,Collections.reverseOrder());
        Collections.sort(B,Collections.reverseOrder());
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1,p2)->p2.sum-p1.sum);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<A.size();i++) maxHeap.add(new Pair(0,i,A.get(0)+B.get(i)));
        for(int i=0;i<A.size();i++) {
            Pair p = maxHeap.poll();
            list.add(p.sum);
            if(p.i==A.size()-1) continue;
            maxHeap.add(new Pair(p.i+1,p.j,A.get(p.i+1)+B.get(p.j)));
        }
        return list;
    }
}
