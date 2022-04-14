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
        
        if(head == null) return head;
        
        if(length(head) < k) return head;
        
        ListNode prev = null, curr = head, next = null;
        int temp = k;
        while(curr!=null && temp > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            temp--;
        }
        if(head!=null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
    public int length(ListNode node) {
        ListNode temp = node;
        int count = 0;
        while(node!=null) {
            node = node.next;
            count++;
        }
        return count;
    }
}