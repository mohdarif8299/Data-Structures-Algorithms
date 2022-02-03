class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;
        int p = nums3.length;
        int q = nums4.length;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i]+nums2[j], 0) +1);
            }
        }
        
        int tuples = 0;
        for(int i = 0;i<p;i++) {
            for(int j = 0;j<q;j++) {
                tuples += map.getOrDefault(-(nums3[i] + nums4[j]), 0);
            }
        }
        return tuples;
    }
}