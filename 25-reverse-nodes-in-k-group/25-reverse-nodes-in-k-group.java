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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null, curr = head, next = null;
        int height = listHeight(head);
        if(height < k) return head;
        
        int r = k;
        while(curr!=null && r > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            r--;
        }
        
        if(head!=null) 
            head.next = reverseKGroup(curr, k);
        return prev;
    }
    
    public int listHeight(ListNode head) {
        int count = 0;
        while(head!=null) {
            count+=1;
            head = head.next;
        }
        return count;
    }
}