class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subset(0, nums, new ArrayList<>(), new ArrayList<>());
    }
    public static List<List<Integer>>  subset(int i, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if(i >= nums.length ) { 
            ans.add(list);
            return ans; 
        }
        list.add(nums[i]);
        subset(i+1, nums, new ArrayList(list), ans);
        list.remove(list.get(list.size()-1));
        subset(i+1, nums, new ArrayList(list), ans);
        return ans;
    }
}