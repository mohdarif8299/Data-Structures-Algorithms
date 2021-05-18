class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max=1;
        int countmax=0;
        for(int i=0;i<rectangles.length;i++) {
             max = Math.max(max,Math.min(rectangles[i][0],rectangles[i][1]));
         }   
        for(int i=0;i<rectangles.length;i++) {
             if(max==Math.min(rectangles[i][0],rectangles[i][1])) countmax+=1;
        }
        return countmax;
    }
}
