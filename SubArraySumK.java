
class Solution {
  public int countSubarrays(int[] A, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int curr = 0;
        int count=0;
        for(int i=0;i<A.length;i++){
           curr+=A[i];
           if(curr==k) count++;
           if(map.containsKey(curr-k)) {
             count+=map.get(curr-k);
           }
           if(!map.containsKey(curr)) {
              map.put(curr,1);
           } else map.put(curr,map.get(curr)+1);
        }
        return count;
  }
}
