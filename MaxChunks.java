class Solution {
    public int maxChunksToSorted(int[] arr) {
        Integer A[] = new Integer[arr.length];
        for(int i=0;i<arr.length;i++) {
            A[i] = arr[i];
        }
        int chunk=0;
        Arrays.sort(A);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i])+1);
            } else {
                map.put(arr[i],1);
            }
            if(map.get(arr[i])==0) map.remove(arr[i]);
            if(map.containsKey(A[i])) {
                map.put(A[i],map.get(A[i])-1);
            } else {
                map.put(A[i],-1);
            }
            if(map.get(A[i])==0) map.remove(A[i]);
            if(map.size()==0) chunk+=1;
        }
        return chunk;
    }
}
