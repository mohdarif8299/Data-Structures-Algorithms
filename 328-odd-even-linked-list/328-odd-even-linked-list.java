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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode oddTemp = head;
        ListNode evenTemp = head.next;
        
        while(oddList!=null && evenList!=null && evenList.next!=null) {
           oddList.next = evenList.next; 
           evenList.next  = evenList.next.next;
           oddList = oddList.next;
           evenList = evenList.next;
        }
        
        oddList.next = evenTemp;
        return oddTemp;
    }
}