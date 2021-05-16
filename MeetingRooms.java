public class Solution {
    public static class Pair {
        int start;
        int end;
        Pair(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solve(int[][] A) {
      Pair[] p = new Pair[A.length];
      for(int i=0;i<A.length;i++) {
          p[i] = new Pair(A[i][0],A[i][1]);
      } 
      Arrays.sort(p,(p1,p2)->p1.start-p2.start);
      PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1,p2)->p1.end-p2.end);
      int room = 1;
      minHeap.add(p[0]);
      for(int i=1;i<p.length;i++) {
          Pair pair = p[i];
          Pair temp = minHeap.peek();
          if(pair.start>=temp.end) {
              minHeap.poll();
              minHeap.add(pair);
          } else {
              minHeap.add(pair);
              room+=1;
          }
      }
      return room;
    }
}
