class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int length = 1;
        Arrays.fill(dp, 1);
        for(int i=1;i<nums.length;i++) {
            for(int j=i-1;j>=0;j--) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    length = Math.max(length, dp[i]);
                }
            }
        }
        return length;
    }
}