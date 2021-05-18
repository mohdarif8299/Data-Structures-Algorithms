class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];
        Arrays.sort(nums);
        int currentSum=0;
        for(int i=nums.length-1;i>=0;i--) {
            currentSum+=nums[i];
            if(currentSum<=sum) {
                sum-=nums[i];
                list.add(nums[i]);
            } 
            else if(currentSum-nums[i]<=sum) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
