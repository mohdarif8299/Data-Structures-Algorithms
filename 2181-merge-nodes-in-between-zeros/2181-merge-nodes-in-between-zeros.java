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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head;
        ListNode next = head.next;
        
        while(next!=null) {
            if(next.val!=0) {
                curr.val += next.val;
            } else {
                
                if(next.next == null) {
                    curr.next = null;
                }else {
                    curr.next = next;
                }
                curr = next;
                
            }
            next = next.next;
        }
        return head;
    }
}