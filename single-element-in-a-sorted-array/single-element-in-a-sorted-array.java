class Solution {
    public int singleNonDuplicate(int[] nums) {
        return nums[binarySearch(nums)];
    }
    public static int binarySearch(int nums[]) {
        int index = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(mid%2==0 && mid < nums.length-1  && nums[mid] == nums[mid+1]) {
                low = mid + 1;
            } else if(mid%2==1 && mid > 0 && nums[mid] == nums[mid-1]) {
                low = mid + 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }
}