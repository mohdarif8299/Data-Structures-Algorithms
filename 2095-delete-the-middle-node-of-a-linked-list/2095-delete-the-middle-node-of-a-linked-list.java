/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode beforeMiddle = null;
        while(fast!=null && fast.next!=null) {
            beforeMiddle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(beforeMiddle == null)
            return beforeMiddle;
        
        beforeMiddle.next = slow.next;
        return head;
    }
}