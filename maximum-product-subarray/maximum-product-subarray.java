class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for(int i=1;i<nums.length; i++) {
            int prevMax = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] *  prevMax, nums[i] * min), nums[i]);
            
            ans = Math.max(ans, max);
        }
        return ans;
    }
}