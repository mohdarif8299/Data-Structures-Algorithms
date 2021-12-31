class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< nums.length;i++)
            list.add(-11);
        return permutation(0, nums.length, nums, list, new ArrayList<>());
    }
    public static List<List<Integer>> permutation(int i, int n,int[] a, List<Integer> list, List<List<Integer>> ans) {
      if(i == n) {
          ans.add(list);
          return ans;
      }   
      for(int j = 0; j< n;j++) {
          if(list.get(j) == -11) {
              list.set(j,a[i]);
              permutation(i+1, n, a, new ArrayList<>(list), ans);
              list.set(j, -11);
          }
      }
        return ans;
    }
}