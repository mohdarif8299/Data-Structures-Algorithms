class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combination(1, n + 1, k, new ArrayList<>(), new ArrayList<>());
    }
    public static List<List<Integer>> combination(int i,int n, int k, List<Integer> list, List<List<Integer>> allList) {
        if(k == 0) {
            allList.add(list);
            return allList;
        }
        if(i == n) return allList;
        list.add(i);
        for(int j=i+1;j<=n;j++) {
            combination(j, n, k - 1, new ArrayList<>(list), allList);
            list.remove(list.size() - 1);
            list.add(j);
        }
        return allList;
    }
}