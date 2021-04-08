class Solution {
    public static class MyComparator implements Comparator<List<Integer>> {
        public int compare(List<Integer> al,List<Integer> al2) {
            if((al.get(0)+al.get(1))==(al2.get(0)+al2.get(1))) return al.get(0)-al2.get(0);
            return (al.get(0)+al.get(1))-(al2.get(0)+al2.get(1));
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<B.length;j++) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(A[i]);
                al.add(B[j]);
                ans.add(al);
            }
        } 
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new MyComparator());
        for(int i=0;i<ans.size();i++) {
            priorityQueue.add(ans.get(i));
        }
        List<List<Integer>> aList = new ArrayList<>();
        while(k!=0 && !priorityQueue.isEmpty()) {
            List<Integer> al = priorityQueue.poll();
            aList.add(al);
            k-=1;
        }
        return aList;
    }
}
