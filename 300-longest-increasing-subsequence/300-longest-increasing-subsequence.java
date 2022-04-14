class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        
        Arrays.fill(dp, 1);
        
        for(int i=1; i<n;i++) {
            for(int j=i-1 ;j>=0;j-- ) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLen = 1;
        for(int i=0;i<dp.length;i++)
            maxLen = Math.max(maxLen, dp[i]);
        return maxLen;
    }
}