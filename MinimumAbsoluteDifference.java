class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDifference = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++) {
            if(minDifference>arr[i+1]-arr[i]) minDifference = arr[i+1]-arr[i];
        }
        List<List<Integer>> ans  =new ArrayList<>();
        for(int i=0;i<arr.length-1;i++) {
            ArrayList<Integer> a = new ArrayList<>();
            if(arr[i+1]-arr[i]==minDifference) {
                a.add(arr[i]);
                a.add(arr[i+1]);
            }
            if(a.size()>0)
            ans.add(a);
        }
        return ans;
    }
}
