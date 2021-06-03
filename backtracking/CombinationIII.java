class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return subset(1,new ArrayList<>(),new ArrayList<>(),k,n);
    }
    public static List<List<Integer>> subset(int i,ArrayList<Integer> list,List<List<Integer>> ans,int k,int target) {
      if(k==0 && target==0) {
          ans.add(list);
          return ans;
      }
      if(i==10) return ans;
          list.add(i);
          subset(i+1,new ArrayList<>(list),ans,k-1,target-i);
          list.remove(list.size()-1);
          subset(i+1,new ArrayList<>(list),ans,k,target);
      return ans;
    }
}
