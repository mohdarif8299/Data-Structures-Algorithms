class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        return robbery(nums.length-1, nums, dp);
    }
    public int robbery(int i, int nums[], int dp[]) {
        if(dp[i] == -1) {
            dp[i] = Math.max(nums[i]+robbery(i-2, nums, dp), robbery(i-1, nums, dp));
        }
        return dp[i];
    }
}