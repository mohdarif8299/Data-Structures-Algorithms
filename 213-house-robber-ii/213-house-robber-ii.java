class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length+1];
        int dp1[] = new int[nums.length+1];
        Arrays.fill(dp, -1);
        Arrays.fill(dp1, -1);
        
        
       // System.out.println(houseRobber(nums.length-2, 0, nums, dp));
       // System.out.println(houseRobber(nums.length-1, 1, nums, dp));
        
        
        int m1 = houseRobber(nums.length-2, 0, nums, dp);
        int m2 = houseRobber(nums.length-1, 1, nums, dp1);
        return Math.max(m1, m2);
    }
    
    public int houseRobber(int i,int last, int nums[], int dp[]) {
        if( last > i  ) return 0;
        if(dp[i] == -1) {
            dp[i] = Math.max(nums[i]+houseRobber(i-2, last, nums, dp), houseRobber(i-1, last, nums, dp ));
        }
        return dp[i];
    }
    
}