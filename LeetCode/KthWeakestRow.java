class Solution {
    public static class Pair {
        int index;
        int level;
        Pair(int index,int level) {
            this.index = index;
            this.level = level;
        }
    }
    public int[] kWeakestRows(int[][] A, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(k,(r1,r2)->{
            if(r1.level==r2.level) return r2.index-r1.index;
            return r2.level-r1.level;
        });
        int R = A.length;
        int C = A[0].length;
        for(int i=0;i<R;i++) {
            int sum=0;
            for(int j=0;j<C;j++) {
                sum+=A[i][j]; 
            }
            Pair p = new Pair(i,sum);
            if(maxHeap.size()<k)
               maxHeap.add(p); 
            else {
                if(sum<maxHeap.peek().level) {
                    int x = maxHeap.poll().level;
                    System.out.println(x);
                    maxHeap.add(p);
                }
            }
        }
        int AR[] = new int[k];
        int j=k-1;
        while(!maxHeap.isEmpty()) {
            AR[j] = maxHeap.poll().index;
            j-=1;
        }
        return AR;
    }
}
