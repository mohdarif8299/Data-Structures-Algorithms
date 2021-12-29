class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new LinkedList<>();
        int ans[] = new int[nums.length - k + 1];
        int index = 0;
        for(int i=0;i<k;i++) {
            while(!deq.isEmpty() && nums[i]>=nums[deq.getLast()]) 
                deq.removeLast();
            deq.addLast(i);
        }
        ans[index++] = nums[deq.getFirst()];
        for(int i=k;i<nums.length;i++) {
            while(!deq.isEmpty() && nums[i]>=nums[deq.getLast()])
                deq.removeLast();
            deq.addLast(i);
            if(!deq.isEmpty() && deq.getFirst() < (i - k + 1))
              deq.removeFirst();  
            ans[index++] = nums[deq.getFirst()];
        }
        return ans;
    }
}