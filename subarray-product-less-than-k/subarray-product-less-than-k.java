class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int p1 = 0, p2 = 0;
        int pro = 1;
        while(p2 < nums.length) {
            pro *= nums[p2];
            while(pro >= k && p1<=p2) {
                pro /= nums[p1];
                p1++;
            }
            count += (p2 - p1 + 1);
            p2++;
        }
        return count;
    }
}