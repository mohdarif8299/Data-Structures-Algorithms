public class Solution {
    public int[] solve(int A, int B, int[] C) {
        Integer min[] = new Integer[C.length];
        Integer max[] = new Integer[C.length];
        for(int i=0;i<C.length;i++) {
            min[i] = C[i];
            max[i] = C[i];
        }
        Arrays.sort(min);
        int minimum = getMinimumCost(A,B,min);
        int maximum = getMaximumCost(A,B,max);
        return new int[]{maximum,minimum};
    }
    public static int getMinimumCost(int A,int B,Integer C[]) {
         int cost=0;
        for(int i=0;i<C.length;i++) {
            while( C[i]!=0 && A!=0) {
                cost+=C[i];
                C[i]-=1;
                A-=1;
            }
        }
         return cost;
    }
    public static int getMaximumCost(int A,int B,Integer C[]) {
        int cost=0;
        int total = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<C.length;i++) maxHeap.add(C[i]);
        while(A!=0 && maxHeap.size()>0) {
            int x = maxHeap.poll();
            if(x!=0) {
                cost+=x;
                maxHeap.add(x-1);
            }
            A-=1;
        }
        return cost;
    }
}
