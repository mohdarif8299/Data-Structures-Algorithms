class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return new ArrayList<>(subsetsWithDup(0, nums, new ArrayList<>(), new HashSet<>()));
    }
    public Set<List<Integer>> subsetsWithDup(int i, int nums[], List<Integer> list, Set<List<Integer>> ans) {
        if(i== nums.length) {
            ans.add(list);
            return ans;
        }
        list.add(nums[i]);
        subsetsWithDup(i+1, nums, new ArrayList<>(list), ans);
        list.remove(list.size()-1);
        subsetsWithDup(i+1, nums, new ArrayList<>(list), ans);
        return ans;
    }
}