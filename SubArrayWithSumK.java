class Solution {
    public int subarraySum(int[] A, int K) {
        int count=0;
        for(int i=1;i<A.length;i++) A[i] = A[i-1]+A[i];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<A.length;i++) {
            if(map.containsKey(A[i]-K)) {
                count+=map.get(A[i]-K);
            } 
            if(map.containsKey(A[i]))
            map.put(A[i],map.get(A[i])+1);
            else map.put(A[i],1);
        }
        return count;
    }
}
