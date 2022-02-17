class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++) list.add(0);
        return permute(0, nums, list, new ArrayList<>(), new HashSet<>());
    }
    public List<List<Integer>> permute(int index, int nums[], List<Integer> list, List<List<Integer>> ans, Set<Integer> set) {
        if(index == nums.length) {
            ans.add(list);
            return ans;
        }
        for(int j=0;j<nums.length;j++) {
            if(!set.contains(nums[j])) {
                list.set(index, nums[j]);
                set.add(nums[j]);
                permute(index+1, nums, new ArrayList<>(list), ans, set);
                set.remove(nums[j]);
            }
        }
        return ans;
    }
}