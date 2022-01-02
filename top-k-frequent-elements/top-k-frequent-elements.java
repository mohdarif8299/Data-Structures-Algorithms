class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, (a, b) -> a.getValue() - b.getValue() );
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(pq.size() < k)
                pq.add(entry);
            else {
                if(pq.peek().getValue() <  entry.getValue()){
                    pq.remove();
                    pq.add(entry);
                }
            }
        }
        
        int ans[] = new int[k];
        for(int i=0; i<k && !pq.isEmpty();i++) {
            ans[i] = pq.remove().getKey();
        }
        return ans;
    }
}