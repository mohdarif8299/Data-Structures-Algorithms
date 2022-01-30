class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        int sum = 0;
        int n = nums.length;
        for(int i=2;i<n;i++) {
            if(nums[i] - nums[i-1] == nums[i-1]-nums[i-2]) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }
        return sum;
    }
}