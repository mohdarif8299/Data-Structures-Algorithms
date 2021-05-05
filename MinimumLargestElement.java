public class Solution {
    public static class Pair {
        int index;
        int value;
        Pair(int value,int index) {
            this.value= value;
            this.index = index;
        }
    }
    public int solve(int[] A, int B) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1,p2)->{ 
            if(p1.value==p2.value) {
                return A[p1.index]-A[p2.index];
            }
            return p1.value-p2.value;
            
        });
        int S[] = new int[A.length];
        for(int i=0;i<A.length;i++) S[i] = A[i];
        for(int i=0;i<A.length;i++) {
            Pair p = new Pair(2*A[i],i);
            minHeap.add(p);
        }
        if(B==0) return minHeap.poll().value;
        for(int i=0;i<B;i++) {
            Pair p = minHeap.peek();
            S[p.index]+=A[p.index];
            minHeap.poll();
            minHeap.add(new Pair(S[p.index]+A[p.index],p.index));
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<S.length;i++) {
            max = Math.max(max,S[i]);
        }
        
        return max;
    }
}
