class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int arr[] = new int[n];
        Arrays.fill(arr, -1);
        for(int i=0;i<2*n-1;i++) {
            if(stack.isEmpty()) {
                stack.push(i%n);
            } else {
                while(!stack.isEmpty() && nums[i%n] > nums[stack.peek()]) 
                    arr[stack.pop()] = nums[i%n];
                stack.push(i%n);
            }
        }
        return arr;
    }
}