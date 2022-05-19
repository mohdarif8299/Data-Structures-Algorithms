class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     
        
        int minSpeed = Integer.MAX_VALUE;
        
        int start = 1;
        int end = Integer.MIN_VALUE;
        
        for(int i=0;i<piles.length;i++) {
             end = Math.max(end, piles[i]);
        }
        
        while(start < end) {
            int mid = (start + end)/2;
            int hours = check(piles, mid);
            if( hours <= h) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return end;
    }
    
    public int check(int arr[], int h) {
        int k = 0;
        for(int i=0;i<arr.length;i++) {
            k += Math.ceil((double) arr[i] / h);
        }
        return k;
    }
    
}