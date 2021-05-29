class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int index=0;
        int low=0,high=arr.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid]<arr[mid+1]) {
                index=mid+1;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return index;
    }
}
