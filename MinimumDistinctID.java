class Solution
{
    int distinctIds(int arr[], int n, int m)
    {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            } else{
                map.put(arr[i],1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int count=0;
        for(int i=0;i<list.size();i++) {
            int x = list.get(i);
            if(x<=m) {
                 count++;
                 m = m-x;
            }
            if(m==0) break;
        }
        return list.size()-count;
        
        // Complete this function
    }
}
