class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
          if(end >= intervals[i][0]) {
              intervals[i][0] = start;
              intervals[i][1] = Math.max(intervals[i][1], end);
          } else {
              List<Integer> ll = new ArrayList<>();
              ll.add(start);
              ll.add(end);
              list.add(ll);
          }
            start = intervals[i][0];
            end = intervals[i][1];
        }
        List<Integer> ll = new ArrayList<>();
        ll.add(start);
        ll.add(end);
        list.add(ll);
        int ans[][] = new int[list.size()][2];
        for(int i=0;i<list.size();i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}