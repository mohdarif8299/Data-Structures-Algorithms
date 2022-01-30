class Solution {
    public boolean canJump(int[] nums) {
        int jump = 0;
        for(int i=0;i<nums.length;i++) {
            if(i>jump) return false;
            jump = Math.max(jump, nums[i]+i);
        }
        return true;
    }
}