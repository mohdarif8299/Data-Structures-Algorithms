class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum += nums[i];
        if(sum%2!=0) return false;
        sum = sum /2;
        Boolean dp[][] = new Boolean[nums.length + 1][sum + 1];
        return partition(0, sum, nums, dp);
    }
    public Boolean partition(int i, int sum , int num[], Boolean dp[][]) {
        if(sum == 0) return true;
        else if( i >= num.length || sum <0) {
            return  false;
        }
        if(dp[i][sum] == null) 
            dp[i][sum] =  partition(i+1,sum - num[i], num, dp) || partition(i+1, sum, num, dp);
        return dp[i][sum];
    }
}