class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++) {
            if(target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
                 if(binarySearch(matrix[i], 0, matrix[i].length - 1, target))
                     return true;
            }
        }
        return false;
    }
    public static boolean binarySearch(int nums[], int start, int end, int target) {
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}