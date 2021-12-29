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
    public ListNode middleNode(ListNode head) {
        ListNode single = head;
        ListNode d = head;
        while(single!=null && d.next!=null) {
            single = single.next;
            d = d.next.next;
            if(d == null) break;
        }
        return single;
    }
}