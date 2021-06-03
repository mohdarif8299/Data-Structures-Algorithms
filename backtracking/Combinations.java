class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combinations(1,n+1,new ArrayList<>(),new ArrayList<>(),k);
    }
    
    public static List<List<Integer>> combinations(int i,int N,List<Integer> list,List<List<Integer>> ans,int k) {
        if(k==0) {
            ans.add(list);
            return ans;
        }
        if(i==N) {
            return ans;
        }
        list.add(i);
        for(int j=i+1;j<=N;j++) {
            combinations(j,N,new ArrayList<>(list),ans,k-1);
            list.remove(list.size()-1);
            list.add(j);
        }
        
        
        
        return ans;
    }
}
