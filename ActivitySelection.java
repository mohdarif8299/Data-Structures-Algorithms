public class Solution {
    public static class Pair {
        int start;
        int end;
        Pair(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solve(int[] A, int[] B) {
        int count=1;
        ArrayList<Pair> activity = new ArrayList<>();
        for(int i=0;i<A.length;i++) {
            activity.add(new Pair(A[i],B[i]));
        }
        Collections.sort(activity,(a1,a2)->a1.end-a2.end);
        Pair p = activity.get(0);
        for(int i=1;i<activity.size();i++) {
            Pair temp = activity.get(i);
            if(p.end<=temp.start) {
                p=temp;
                count+=1;
            }
        }
        return count;
    }
}
