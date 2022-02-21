class Solution {
    public int rob(int[] nums) {
       int dp[] = new int[nums.length+1];
        
        if(nums.length == 1) return nums[0];
        Arrays.fill(dp, -1);
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        return robHouse(nums.length-1, nums, dp);
    }
            
        public int robHouse(int i, int nums[], int dp[]) {
            
            if(i <= 1) return dp[i];
            
            if(dp[i] == -1){
                dp[i] = Math.max(nums[i]+robHouse(i-2, nums, dp), robHouse(i-1, nums, dp));
            }
            
            return dp[i];
            
        }
}