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
        if(head == null || head.next == null ) return head;
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        int c = 0;
        int height = listHeight(head);
        if(k > height) {
            return curr;
        } else {
            while(curr!=null && c<k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                c++;
            }
        }
       if(head != null)
        head.next = reverseKGroup(next, k);
       return prev;
    }
    public static int listHeight(ListNode node) {
        ListNode temp = node;
        int height = 0;
        while(temp!=null) {
            height++;
            temp = temp.next;
        }
        return height;
    }
}