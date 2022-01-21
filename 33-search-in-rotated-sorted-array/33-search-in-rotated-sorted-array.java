class Solution {
    public int search(int[] nums, int target) {
        int k = rotatedIndex(nums);
        
        int low = 0, high = k-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            }  else {
                high = mid - 1;
            }
        }
        
        low = k;
        high = nums.length-1;
        
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            }  else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
    public int rotatedIndex(int A[]) {
        int low = 0, high = A.length-1;
        int index = 0;
        while(low <= high) {
            int mid = (low + high)/2;
            if(A[0] > A[mid]) {
                index = mid;
                high = mid-1;
            } else 
                low = mid+1;
        }
        return index;
    }
}