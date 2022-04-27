class Solution {
    public void sortColors(int[] nums) {
        int start = 0, index = 0, end = nums.length-1;
        
        while(index<=end) {
            if(nums[index] == 0) {
                swap(nums, index, start);
                index++;
                start++;
            } else if(nums[index] == 2) {
                swap(nums, index, end);
                end--;
                
            } else
                index++;
        }
        
    }
    public static void swap(int nums[], int start, int index) {
        int temp = nums[start];
        nums[start] = nums[index];
        nums[index] = temp;
    }
}