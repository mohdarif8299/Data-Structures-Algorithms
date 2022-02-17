class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(0, candidates, new ArrayList<>(), new ArrayList<>(), target);
    }
    public List<List<Integer>> combinationSum(int i, int candidates[], List<Integer> list, List<List<Integer>> ans, int target) {
        if(target < 0) return ans;
        if(target == 0) {
            ans.add(list);
            return ans;
        }
        if(i == candidates.length) {
            return ans;
        }
        list.add(candidates[i]);
        combinationSum(i, candidates, new ArrayList<>(list), ans, target - candidates[i]);
        list.remove(list.size()-1);
        combinationSum(i+1, candidates, new ArrayList<>(list), ans, target);
        return ans;
    }
}