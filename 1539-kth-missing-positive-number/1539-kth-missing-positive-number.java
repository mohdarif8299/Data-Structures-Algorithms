class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        while(k>0) {
            if(Arrays.binarySearch(arr, i) < 0)
                k--;
            i++;
        }
        return i-1;
    }
}