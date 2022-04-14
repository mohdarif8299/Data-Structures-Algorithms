class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        ways(0, nums, 0, target);
        return count;
    }
    
    public void ways(int i, int[] nums, int sum ,int target) {
       if(i == nums.length) {
           if(sum == target) {
               count++;
           }
       } 
       else {
           ways(i+1, nums, sum-nums[i], target);
           ways(i+1, nums, sum+nums[i], target);
       }
    }
     
}