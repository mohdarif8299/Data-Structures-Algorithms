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
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val == val)
            head = head.next;
        
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            if(temp.val == val) {
                while(temp!=null && temp.val == val) {
                    temp = temp.next;
                }  
                if(prev!=null)
                    prev.next = temp;
            }
            prev = temp;
            if(temp!=null)
                temp = temp.next;
        }
        return head;
    }
}