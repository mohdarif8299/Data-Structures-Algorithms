class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int index = 0;
        int prev = nums[0];
        int k=1;
        nums[index++] = nums[p++];
        while(p < nums.length) {
           if(nums[p] == prev) {
               k++;
           }  else {
               k = 1;
               prev = nums[p];
           }      
           if(k<=2) {
               nums[index++] = nums[p];
           }
            p++;
        }
        return index;
    }
}