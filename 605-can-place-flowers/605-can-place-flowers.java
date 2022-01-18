class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        if(flowerbed.length == 1){
            if(flowerbed[0] == 1 ) return false;
            return true;
        }
        int placed = 0;
        int i=0;
        while(i<flowerbed.length) {
            if(flowerbed[i] == 1) {
                i+=2;
            }
            else {
                if(i+1 < flowerbed.length && flowerbed[i+1] != 1) {
                    placed++;
                    if(placed == n)
                        return true;
                    i += 2;
                } else if(i == flowerbed.length-1 && flowerbed[i-1]!=1) {
                     placed++;
                    if(placed == n)
                        return true;
                    i += 2;
                }
                else i += 1;
            }
        }
        
        return false;
    }
}