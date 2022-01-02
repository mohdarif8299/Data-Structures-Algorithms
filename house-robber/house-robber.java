class Solution {
    public int rob(int[] nums) {
      int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxAmount(nums.length - 1, nums, dp);
    }
    public static int maxAmount(int i,int nums[], int dp[]) {
        if(i==0) return nums[0];
        if(i == 1) return Math.max(nums[0], nums[1]);
        if(dp[i] == -1) {
            dp[i] = Math.max(nums[i] + maxAmount(i-2, nums, dp), maxAmount(i-1, nums, dp));
        } 
        return dp[i];
    }
}