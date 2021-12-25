class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int start = lowBinarySearch(nums, target);
        int end = highBinarySearch(nums, target);
        System.out.println(start +" "+ end);
        List<Integer> list = new ArrayList<>();
        for(int i=start ; i<=end && i>=0 ;i++) 
            list.add(i);
        return list;
    }
    public static int lowBinarySearch(int nums[], int target) {
        int index = -1;
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == target) {
              index = mid;
              high = mid - 1;
            } else if(nums[mid] < target){
               low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
    public static int highBinarySearch(int nums[], int target) {
        int index = -1;
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == target) {
                index = mid;
                low = mid + 1;
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}