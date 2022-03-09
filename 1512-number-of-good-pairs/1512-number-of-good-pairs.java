class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++) 
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        
        for(int i: map.keySet()) {
            int n = map.get(i);
            count += ((n *(n-1))/2);
        }
        return count;
    }
}