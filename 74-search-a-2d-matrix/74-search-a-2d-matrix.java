class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++) {
            if(target >=matrix[i][0] || target <= matrix[i][matrix[i].length-1])
                if(binarySearch(matrix[i], 0, matrix[i].length-1, target))
                    return true;
        }
        return false;
    }
    public static boolean binarySearch(int a[],int low, int high, int target) {
        while(low<=high) {
            int mid = (low + high)/2;
            if(a[mid] == target)
                return true;
            else if(target < a[mid])
                high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}