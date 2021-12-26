class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int p1 = 0, p2 = nums.length - 1;
        while(p1 < p2) {
            max = Math.max(nums[p1]+nums[p2], max);
            p1++;
            p2--;
        }
        return max;
    }
}