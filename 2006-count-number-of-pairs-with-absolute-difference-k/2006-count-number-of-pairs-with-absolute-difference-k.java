class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map  = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++) {
           
            if(map.containsKey(nums[i]-k)) count += map.get(nums[i]-k);
            if(map.containsKey(nums[i]+k)) count += map.get(nums[i]+k);
            
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        return count;
    }
}